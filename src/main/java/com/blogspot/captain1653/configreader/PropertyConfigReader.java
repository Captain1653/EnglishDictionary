package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.ExternalProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.blogspot.captain1653.ExternalProperty.*;

public class PropertyConfigReader implements ConfigReader {

    private static final String EMPTY_VALUE_FOLDER_FOR_FILES = "";
    private static final String SEPARATOR_FOR_FILES = ",";

    private String pathToConfigFile;

    public PropertyConfigReader(String pathToConfigFile) {
        this.pathToConfigFile = pathToConfigFile;
    }

    @Override
    public Configuration readConfiguration() throws IOException {
        Properties properties;
        try (InputStream input = new FileInputStream(pathToConfigFile)) {
            properties = new Properties();
            properties.load(input);
        }
        Configuration configuration = new Configuration();
        configuration.setQuestionStrategy(properties.getProperty(MODE));
        String[] fileNamesWithWords = properties.getProperty(FILES).split(SEPARATOR_FOR_FILES);
        configuration.setPathFiles(fileNamesWithWords);
        configuration.setTypeWord(properties.getProperty(TYPE_WORD));
        configuration.setFolderForFiles(properties.getProperty(FOLDER,EMPTY_VALUE_FOLDER_FOR_FILES));
        configuration.setOrder(properties.getProperty(ExternalProperty.ORDER));

        return configuration;
    }
}
