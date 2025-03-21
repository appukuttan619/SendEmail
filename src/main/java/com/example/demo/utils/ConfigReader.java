package com.example.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    public static String getProperty(String key)  {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);
    }
}
