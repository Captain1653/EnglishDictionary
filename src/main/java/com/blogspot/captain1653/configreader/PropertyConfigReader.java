package com.blogspot.captain1653.configreader;

import static com.blogspot.captain1653.ExternalProperty.MODE;
import static com.blogspot.captain1653.ExternalProperty.PATH_TO_FILE;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.mode.EnglishQuestionStrategy;
import com.blogspot.captain1653.mode.MixQuestionStrategy;
import com.blogspot.captain1653.mode.QuestionStrategy;
import com.blogspot.captain1653.mode.RussianQuestionStrategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyConfigReader implements ConfigReader {

    @Override
    public Configuration readConfiguration(String pathToConfigFile) throws IOException {
        Properties properties;
        try (InputStream input = new FileInputStream(pathToConfigFile)) {
            properties = new Properties();
            properties.load(input);
        }
        Configuration configuration = new Configuration();

        String mode = properties.getProperty(MODE.get(), QuestionModeConstants.EN);
        QuestionStrategy questionStrategy = getQuestionStrategy(mode);
        configuration.setQuestionStrategy(questionStrategy);

        configuration.setPathFile(properties.getProperty(PATH_TO_FILE.get()));
        return configuration;
    }

    private QuestionStrategy getQuestionStrategy(String questionMode) {
        switch (questionMode) {
            case QuestionModeConstants.MIX: return new MixQuestionStrategy();
            case QuestionModeConstants.RU: return new RussianQuestionStrategy();
            default: return new EnglishQuestionStrategy();
        }
    }

    private static class QuestionModeConstants {
        private static final String RU = "ru";
        private static final String EN = "en";
        private static final String MIX = "mix";
    }
}
