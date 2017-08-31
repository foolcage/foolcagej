package com.foolcage.foolcompute.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xuanqi on 17-6-9.
 */
public class PropertyUtils {
    public static Properties getProperties() {
        try (final InputStream stream =
                     PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
            final Properties properties = new Properties();
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
