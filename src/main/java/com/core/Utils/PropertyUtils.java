package com.core.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {


    public static Properties propertyLoader(String filePath) throws IOException {
        Properties properties = new Properties();
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new FileReader(filePath));
        properties.load(bufferedReader);
        bufferedReader.close();
        return properties;
    }
}
