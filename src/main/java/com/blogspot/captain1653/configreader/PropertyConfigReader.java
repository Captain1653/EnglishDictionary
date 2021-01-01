package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.ExternalProperty;
import com.blogspot.captain1653.dictionary.scala.DictionaryConfiguration;

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
    public DictionaryConfiguration readConfiguration() throws IOException {
        Properties properties;
        try (InputStream input = new FileInputStream(pathToConfigFile)) {
            properties = new Properties();
            properties.load(input);
        }
        String[] fileNamesWithWords = properties.getProperty(FILES).split(SEPARATOR_FOR_FILES);
        return new DictionaryConfiguration(
                properties.getProperty(MODE),
                fileNamesWithWords,
                properties.getProperty(TYPE_WORD),
                properties.getProperty(FOLDER,EMPTY_VALUE_FOLDER_FOR_FILES),
                properties.getProperty(ExternalProperty.ORDER)
        );
    }
}
