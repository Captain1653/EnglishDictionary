package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.dictionary.scala.TypeWordPredicateFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyFileConfigReader {

    private final static TypeWordPredicateFactory TYPE_WORD_PREDICATE_FACTORY = TypeWordPredicateFactory.createFactory();

    @Test
    void readConfigWithAllParameters() throws IOException {
        String pathToFile = "src/test/resources/configreader/fullConfiguration.properties";
        ConfigReader configReader = new PropertyConfigReader(TYPE_WORD_PREDICATE_FACTORY);
        Configuration configuration = configReader.readConfiguration(pathToFile);

        assertEquals("someFolder/", configuration.getFolderForFiles());
        assertArrayEquals(new String[]{"one.txt", "two.txt"}, configuration.getPathFiles());
        assertEquals("ru", configuration.getQuestionStrategy());
        assertTrue(configuration.getTypeWordPredicate().test("noun"));
        assertEquals("seq",configuration.getOrder());
    }

    @Test
    void readConfigWithDefaultValueFolderEmptyString() throws IOException {
        String pathToFile = "src/test/resources/configreader/defaultValueFolderEmptyString.properties";
        ConfigReader configReader = new PropertyConfigReader(TYPE_WORD_PREDICATE_FACTORY);
        Configuration configuration = configReader.readConfiguration(pathToFile);

        assertEquals("", configuration.getFolderForFiles());
    }
}
