package com.foolcage.foolcompute.codec;

import com.alibaba.fastjson.JSON;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuanqi on 17-6-9.
 */
public class JsonSchema<T> implements DeserializationSchema<T>, SerializationSchema<T> {
    public static final Logger LOGGER = LoggerFactory.getLogger(JsonSchema.class);

    private static final long serialVersionUID = 1L;

    private Class<T> type;

    public JsonSchema(Class<T> type) {
        this.type = type;
    }

    public JsonSchema() {
    }

    @Override
    public T deserialize(byte[] message) {
        T result = null;
        try {
            result = JSON.parseObject(message, type);
        } catch (Exception e) {
            String json = new String(message);
            LOGGER.error("message:{} deserialize failed", json, e);
        }
        return result;
    }

    @Override
    public boolean isEndOfStream(T t) {
        return false;
    }

    @Override
    public TypeInformation<T> getProducedType() {
        return TypeInformation.of(type);
    }

    @Override
    public byte[] serialize(T t) {
        return JSON.toJSONBytes(t);
    }
}