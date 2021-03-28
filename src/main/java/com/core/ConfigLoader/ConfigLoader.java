package com.core.ConfigLoader;

import com.core.Constants.Constants;
import com.core.Utils.PropertyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private final Properties properties;

    private ConfigLoader() throws IOException {
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + File.separator + Constants.CONFIG_PROPERTIES);
    }

    public static ConfigLoader getInstance() throws IOException {
        if (configLoader == null)
            return new ConfigLoader();
        else
            return configLoader;
    }


    public String getPropertyValue(String key) {
        String value = properties.getProperty(key);
        if (value != null)
            return value;
        else
            throw new RuntimeException("value is null for key");
    }


}
