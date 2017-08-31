package com.foolcage.foolcompute.job;

import com.alibaba.fastjson.JSON;
import com.foolcage.common.domain.Stock;
import com.foolcage.foolcompute.codec.JsonSchema;
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
public class StoreSecurityJob {
    public static final Logger LOGGER = LoggerFactory.getLogger(StoreSecurityJob.class);

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        // only required for Kafka 0.8
        properties.setProperty("zookeeper.connect", "localhost:2181");
        properties.setProperty("group.id", "fool_compute");
        properties.setProperty("auto.offset.reset", "earliest");

        // create a Kafka consumer
        FlinkKafkaConsumer010<Stock> consumer = new FlinkKafkaConsumer010<>(
                "CHINA_STOCK",
                new JsonSchema<>(Stock.class),
                properties);
        DataStream<Stock> dataStream = env.addSource(consumer)
                .filter(new FilterFunction<Stock>() {
                    @Override
                    public boolean filter(Stock stock) throws Exception {
                        return stock != null;
                    }
                }).map(new MapFunction<Stock, Stock>() {
                    @Override
                    public Stock map(Stock stock) throws Exception {
                        stock.setId(stock.getType() + "_" + stock.getExchange() + "_" + stock.getCode());
                        return stock;
                    }
                });

        try {
            Map<String, String> config = new HashMap<>();
            config.put("cluster.name", "elasticsearch");
            // This instructs the sink to emit after every element, otherwise they would be buffered
            config.put("bulk.flush.max.actions", "1");

            List<InetSocketAddress> transportAddresses = new ArrayList<>();
            transportAddresses.add(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9300));

            dataStream.addSink(new ElasticsearchSink<>(config, transportAddresses, new ElasticsearchSinkFunction<Stock>() {
                public IndexRequest createIndexRequest(Stock element) {
                    return Requests.indexRequest()
                            .index("security")
                            .type("stock")
                            .id(element.getId())
                            .source(JSON.toJSONString(element));
                }

                public UpdateRequest createUpdateRequest(Stock element) {
                    return new UpdateRequest("security", "stock", element.getId())
                            .doc(JSON.toJSONString(element)).upsert(createIndexRequest(element));
                }

                @Override
                public void process(Stock element, RuntimeContext ctx, RequestIndexer indexer) {
                    indexer.add(createUpdateRequest(element));
                }
            }));
            env.execute("store stock to es");
        } catch (Exception e) {
            LOGGER.error("failed");
        }

    }

}
