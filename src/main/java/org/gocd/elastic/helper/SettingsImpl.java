package org.gocd.elastic.helper;

import com.google.inject.Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class SettingsImpl implements Settings {

    private Properties properties;

    public SettingsImpl() throws IOException {
        System.out.println("Initializing settings");
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");

        if(inputStream != null) {
            properties.load(inputStream);
        }

    }

    @Override
    public String get(String key) {
        return properties.getProperty(key);
    }
}
