package org.apache.spark.examples.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.elasticsearch.spark.rdd.api.java.JavaEsSpark;
import org.spark_project.guava.collect.ImmutableList;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuanqi on 17-8-23.
 */
public class EsTest {
    public static class TripBean implements Serializable {
        private String departure, arrival;
        private Date timestamp;

        public TripBean(String departure, String arrival) {
            setDeparture(departure);
            setArrival(arrival);
            setTimestamp(new Date());
        }

        public TripBean() {
        }

        public String getDeparture() {
            return departure;
        }

        public String getArrival() {
            return arrival;
        }

        public void setDeparture(String dep) {
            departure = dep;
        }

        public void setArrival(String arr) {
            arrival = arr;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {


        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("EsTest");

        JavaSparkContext jsc = new JavaSparkContext(conf);


        TripBean upcoming = new TripBean("OTP", "SFO");
        TripBean lastWeek = new TripBean("MUC", "OTP");

        JavaRDD<TripBean> javaRDD = jsc.parallelize(
                ImmutableList.of(upcoming, lastWeek));
        JavaEsSpark.saveToEs(javaRDD, "spark/docs");
    }
}
