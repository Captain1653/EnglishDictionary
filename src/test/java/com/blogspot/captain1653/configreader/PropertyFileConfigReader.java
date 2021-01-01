package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.dictionary.scala.DictionaryConfiguration;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyFileConfigReader {

    @Test
    void readConfigWithAllParameters() throws IOException {
        String pathToFile = "src/test/resources/configreader/fullConfiguration.properties";
        ConfigReader configReader = new PropertyConfigReader(pathToFile);
        DictionaryConfiguration configuration = configReader.readConfiguration();

        assertEquals("someFolder/", configuration.folderForFiles());
        assertArrayEquals(new String[]{"one.txt", "two.txt"}, configuration.pathFiles());
        assertEquals("ru", configuration.questionStrategy());
        assertEquals("noun", configuration.typeWord());
        assertEquals("seq",configuration.order());
    }

    @Test
    void readConfigWithDefaultValueFolderEmptyString() throws IOException {
        String pathToFile = "src/test/resources/configreader/defaultValueFolderEmptyString.properties";
        ConfigReader configReader = new PropertyConfigReader(pathToFile);
        DictionaryConfiguration configuration = configReader.readConfiguration();

        assertEquals("", configuration.folderForFiles());
    }
}
