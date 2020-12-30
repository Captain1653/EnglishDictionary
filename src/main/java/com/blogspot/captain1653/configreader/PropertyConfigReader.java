package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.ExternalProperty;
import com.blogspot.captain1653.dictionary.scala.TypeWordPredicateFactory;
import com.blogspot.captain1653.mode.QuestionStrategy;
import com.blogspot.captain1653.mode.QuestionStrategyFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Predicate;

import static com.blogspot.captain1653.ExternalProperty.*;

public class PropertyConfigReader implements ConfigReader {

    private static final String EMPTY_VALUE_FOLDER_FOR_FILES = "";
    private static final String SEPARATOR_FOR_FILES = ",";

    private QuestionStrategyFactory questionStrategyFactory;
    private TypeWordPredicateFactory typeWordPredicateFactory;

    public PropertyConfigReader(QuestionStrategyFactory questionStrategyFactory,
                                TypeWordPredicateFactory typeWordPredicateFactory) {
        this.questionStrategyFactory = questionStrategyFactory;
        this.typeWordPredicateFactory = typeWordPredicateFactory;
    }

    @Override
    public Configuration readConfiguration(String pathToConfigFile) throws IOException {
        Properties properties;
        try (InputStream input = new FileInputStream(pathToConfigFile)) {
            properties = new Properties();
            properties.load(input);
        }
        Configuration configuration = new Configuration();

        String mode = properties.getProperty(MODE);
        QuestionStrategy questionStrategy = questionStrategyFactory.create(mode);
        configuration.setQuestionStrategy(questionStrategy);

        String[] fileNamesWithWords = properties.getProperty(FILES).split(SEPARATOR_FOR_FILES);
        configuration.setPathFiles(fileNamesWithWords);

        String typeWord = properties.getProperty(TYPE_WORD);
        Predicate<String> predicate = typeWordPredicateFactory.create(typeWord);
        configuration.setTypeWordPredicate(predicate);

        String folderForFiles = properties.getProperty(FOLDER,EMPTY_VALUE_FOLDER_FOR_FILES);
        configuration.setFolderForFiles(folderForFiles);

        String order = properties.getProperty(ExternalProperty.ORDER);
        configuration.setOrder(order);

        return configuration;
    }
}
