package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.TypeWordPredicateFactory;
import com.blogspot.captain1653.mode.QuestionStrategyFactory;
import com.blogspot.captain1653.mode.RussianQuestionStrategy;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyFileConfigReader {

    @Test
    void readConfigWithAllParameters() throws IOException {
        String pathToFile = "src/test/resources/configreader/fullConfiguration.properties";
        QuestionStrategyFactory questionStrategyFactory = new QuestionStrategyFactory();
        TypeWordPredicateFactory typeWordPredicateFactory = new TypeWordPredicateFactory();
        ConfigReader configReader = new PropertyConfigReader(questionStrategyFactory, typeWordPredicateFactory);
        Configuration configuration = configReader.readConfiguration(pathToFile);

        assertEquals("someFolder/", configuration.getFolderForFiles());
        assertArrayEquals(new String[]{"one.txt", "two.txt"}, configuration.getPathFiles());
        assertEquals(RussianQuestionStrategy.class, configuration.getQuestionStrategy().getClass());
        assertTrue(configuration.getTypeWordPredicate().test("noun"));
    }

    @Test
    void readConfigWithDefaultValueFolderEmptyString() throws IOException {
        String pathToFile = "src/test/resources/configreader/defaultValueFolderEmptyString.properties";
        QuestionStrategyFactory questionStrategyFactory = new QuestionStrategyFactory();
        TypeWordPredicateFactory typeWordPredicateFactory = new TypeWordPredicateFactory();
        ConfigReader configReader = new PropertyConfigReader(questionStrategyFactory, typeWordPredicateFactory);
        Configuration configuration = configReader.readConfiguration(pathToFile);

        assertEquals("", configuration.getFolderForFiles());
    }
}
