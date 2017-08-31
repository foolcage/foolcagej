package com.foolcage.foolcompute.spark.task;

import com.alibaba.fastjson.JSON;
import com.foolcage.common.domain.KData;
import kafka.serializer.StringDecoder;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;
import org.elasticsearch.spark.streaming.api.java.JavaEsSparkStreaming;
import scala.Tuple2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanqi on 17-8-25.
 */
public class KdataTask {
    public static void main(String[] args) {
        String brokers = "localhost:9092";
        String topics = "stock_sz_000002_day_kdata";

        // Create context with a 2 seconds batch interval
        SparkConf sparkConf = new SparkConf().setMaster("local[2]").setAppName("JavaDirectKafkaWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, Durations.seconds(2));

        Set<String> topicsSet = new HashSet<>(Arrays.asList(topics.split(",")));
        Map<String, String> kafkaParams = new HashMap<>();
        kafkaParams.put("metadata.broker.list", brokers);
        kafkaParams.put("bootstrap.servers", brokers);
        kafkaParams.put("auto.offset.reset", "smallest");

        // Create direct kafka stream with brokers and topics
        JavaPairInputDStream<String, String> messages = KafkaUtils.createDirectStream(
                jssc,
                String.class,
                String.class,
                StringDecoder.class,
                StringDecoder.class,
                kafkaParams,
                topicsSet
        );

        JavaDStream<KData> lines = messages.map(new Function<Tuple2<String, String>, KData>() {
            @Override
            public KData call(Tuple2<String, String> stringStringTuple2) throws Exception {
                return JSON.parseObject(stringStringTuple2._2(), KData.class);
            }
        });


        JavaEsSparkStreaming.saveToEs(lines, "stock_sz_000002_day_kdata/kdata");

        // Start the computation
        jssc.start();
        try {
            jssc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
