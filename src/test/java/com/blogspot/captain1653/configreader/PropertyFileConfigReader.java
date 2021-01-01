package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.Configuration;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyFileConfigReader {

    @Test
    void readConfigWithAllParameters() throws IOException {
        String pathToFile = "src/test/resources/configreader/fullConfiguration.properties";
        ConfigReader configReader = new PropertyConfigReader(pathToFile);
        Configuration configuration = configReader.readConfiguration();

        assertEquals("someFolder/", configuration.getFolderForFiles());
        assertArrayEquals(new String[]{"one.txt", "two.txt"}, configuration.getPathFiles());
        assertEquals("ru", configuration.getQuestionStrategy());
        assertEquals("noun", configuration.getTypeWord());
        assertEquals("seq",configuration.getOrder());
    }

    @Test
    void readConfigWithDefaultValueFolderEmptyString() throws IOException {
        String pathToFile = "src/test/resources/configreader/defaultValueFolderEmptyString.properties";
        ConfigReader configReader = new PropertyConfigReader(pathToFile);
        Configuration configuration = configReader.readConfiguration();

        assertEquals("", configuration.getFolderForFiles());
    }
}
