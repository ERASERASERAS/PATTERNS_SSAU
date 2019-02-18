package com.company.patterns;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader ourInstance = new ConfigLoader();

    private static Properties propertiesFile;

    private static final  String PROPERTIES_FILE_URL = "src/main/resources/config.properties";

    public static ConfigLoader getInstance() {
        return ourInstance;
    }

    private ConfigLoader() {
    }

    public  Properties getPropertiesFile() throws IOException {
        if(propertiesFile == null) {
            propertiesFile = new Properties();
            FileInputStream fileInputStream  = new FileInputStream(PROPERTIES_FILE_URL);
            propertiesFile.load(fileInputStream);
        }
        return propertiesFile;
    }
}
