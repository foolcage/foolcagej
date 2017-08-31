package com.foolcage.foolcompute.job;

import com.alibaba.fastjson.JSON;
import com.foolcage.common.domain.KData;
import com.foolcage.foolcompute.codec.JsonSchema;
import com.foolcage.foolcompute.utils.DateUtils;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch5.ElasticsearchSink;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Requests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by xuanqi on 17-5-24.
 */
public class StoreKDataJob {
    public static final Logger LOGGER = LoggerFactory.getLogger(StoreKDataJob.class);

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        // only required for Kafka 0.8
        properties.setProperty("zookeeper.connect", "localhost:2181");
        properties.setProperty("group.id", "fool_compute");
        properties.setProperty("auto.offset.reset", "earliest");

        // create a Kafka consumer
        FlinkKafkaConsumer010<KData> consumer = new FlinkKafkaConsumer010<>(
                "CHINA_STOCK_KDATA_DAY",
                new JsonSchema<>(KData.class),
                properties);
        DataStream<KData> dataStream = env.addSource(consumer)
                .filter(new FilterFunction<KData>() {
                    @Override
                    public boolean filter(KData kData) throws Exception {
                        return kData != null;
                    }
                }).map(new MapFunction<KData, KData>() {
                    @Override
                    public KData map(KData kData) throws Exception {
                        kData.setId(kData.getSecurityId() + "_" + kData.getLevel() + "_" + DateUtils.dateToStr(kData
                                .getTimestamp(), true));
                        return kData;
                    }
                });

        try {
            Map<String, String> config = new HashMap<>();
            config.put("cluster.name", "elasticsearch");
            // This instructs the sink to emit after every element, otherwise they would be buffered
            config.put("bulk.flush.max.actions", "1");

            List<InetSocketAddress> transportAddresses = new ArrayList<>();
            transportAddresses.add(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9300));

            dataStream.addSink(new ElasticsearchSink<>(config, transportAddresses, new ElasticsearchSinkFunction<KData>
                    () {
                public IndexRequest createIndexRequest(KData element) {
                    return Requests.indexRequest()
                            .index("kdata")
                            .type("day")
                            .id(element.getId())
                            .source(JSON.toJSONString(element));
                }

                public UpdateRequest createUpdateRequest(KData element) {
                    return new UpdateRequest("kdata", "day", element.getId())
                            .doc(JSON.toJSONString(element)).upsert(createIndexRequest(element));
                }

                @Override
                public void process(KData element, RuntimeContext ctx, RequestIndexer indexer) {
                    indexer.add(createUpdateRequest(element));
                }
            }));
            env.execute("store day kdata to es");
        } catch (Exception e) {
            LOGGER.error("failed");
        }

    }

}
