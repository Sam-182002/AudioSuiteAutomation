package com.audiosuite.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(
                "src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("config.properties not found: " + e.getMessage());
        }
    }

    public String getConfigData(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key not found in config.properties: " + key);
        }
        return value.trim();
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
