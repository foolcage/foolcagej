package com.foolcage.foolcompute.spark.task;

import com.alibaba.fastjson.JSON;
import kafka.serializer.Decoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuanqi on 17-8-25.
 */
public class JsonDecoder<T> implements Decoder<T> {
    public static final Logger LOGGER = LoggerFactory.getLogger(JsonDecoder.class);

    private Class<T> type;

    public JsonDecoder(Class<T> type) {
        this.type = type;
    }

    @Override
    public T fromBytes(byte[] bytes) {
        T result = null;
        try {
            result = JSON.parseObject(bytes, type);
        } catch (Exception e) {
            String json = new String(bytes);
            LOGGER.error("fromBytes:{} failed", json, e);
        }
        return result;
    }
}
