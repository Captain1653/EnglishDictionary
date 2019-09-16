package com.blogspot.captain1653.wordsreader;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.WordWithTranslation;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextFileWordsReaderTest {

    @Test
    void readAllTypesWords() throws IOException {
        String pathToFile = "wordsreader/readAllWords.txt";
        Configuration configuration = getConfigurationWithPathFile(pathToFile);
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Arrays.asList("noun;house=дом", "adjective;next=следующий");
        assertEquals(expected, actual);
    }

    private Configuration getConfigurationWithPathFile(String pathToFile) {
        Configuration configuration = new Configuration();
        configuration.setPathFiles(new String[]{pathToFile});
        configuration.setFolderForFiles("src/test/resources/");
        return configuration;
    }

    @Test
    void readOnlyNounsByPredicate() throws IOException {
        String pathToFile = "wordsreader/readNouns.txt";
        Configuration configuration = getConfigurationWithPathFile(pathToFile);
        Predicate<String> typeWordPredicate = line -> line.startsWith("noun");

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Collections.singletonList("noun;house=дом");
        assertEquals(expected, actual);
    }
}
