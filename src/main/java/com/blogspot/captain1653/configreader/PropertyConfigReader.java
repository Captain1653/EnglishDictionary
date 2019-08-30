package com.blogspot.captain1653.configreader;

import static com.blogspot.captain1653.ExternalProperty.FILES;
import static com.blogspot.captain1653.ExternalProperty.MODE;
import static com.blogspot.captain1653.ExternalProperty.TYPE_WORD;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.TypeWordPredicateFactory;
import com.blogspot.captain1653.mode.QuestionStrategy;
import com.blogspot.captain1653.mode.QuestionStrategyFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Predicate;

public class PropertyConfigReader implements ConfigReader {

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

        String mode = properties.getProperty(MODE.get());
        QuestionStrategy questionStrategy = questionStrategyFactory.create(mode);
        configuration.setQuestionStrategy(questionStrategy);

        String[] fileNamesWithWords = properties.getProperty(FILES.get()).split(",");
        configuration.setPathFiles(fileNamesWithWords);

        String typeWord = properties.getProperty(TYPE_WORD.get());
        Predicate<String> predicate = typeWordPredicateFactory.create(typeWord);
        configuration.setTypeWordPredicate(predicate);

        return configuration;
    }
}
