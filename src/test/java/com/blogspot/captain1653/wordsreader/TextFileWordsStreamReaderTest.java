package com.blogspot.captain1653.wordsreader;

import com.blogspot.captain1653.Configuration;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextFileWordsStreamReaderTest {

    private static final String TEST_RESOURCES = "src/test/resources/";

    @Test
    void readAllTypesWords() throws IOException {
        String pathToFile = "wordsreader/readAllWords.txt";
        Configuration configuration = getConfigurationWithPathFile(pathToFile, TEST_RESOURCES);
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Arrays.asList("noun;house=дом", "adjective;next=следующий");
        assertEquals(expected, actual);
    }

    private Configuration getConfigurationWithPathFile(String pathToFile, String folderForFiles) {
        Configuration configuration = new Configuration();
        configuration.setPathFiles(new String[]{pathToFile});
        configuration.setFolderForFiles(folderForFiles);
        return configuration;
    }

    @Test
    void readOnlyNounsByPredicate() throws IOException {
        String pathToFile = "wordsreader/readNouns.txt";
        Configuration configuration = getConfigurationWithPathFile(pathToFile, TEST_RESOURCES);
        Predicate<String> typeWordPredicate = line -> line.startsWith("noun");

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Collections.singletonList("noun;house=дом");
        assertEquals(expected, actual);
    }

    @Test
    void skipEmptyLinesFromFile() throws IOException {
        String pathToFile = "wordsreader/skipEmptyLinesFromFile.txt";
        Configuration configuration = getConfigurationWithPathFile(pathToFile, TEST_RESOURCES);
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Arrays.asList("noun;house=дом", "adjective;next=следующий");
        assertEquals(expected, actual);
    }

    @Test
    void readAllFilesInTheFolderWhenPathToFilesIsStar() throws IOException {
        String pathToFile = "*";
        String folderWithFiles = TEST_RESOURCES + "wordsreader/readAllFilesInFolder/";
        Configuration configuration = getConfigurationWithPathFile(pathToFile, folderWithFiles);
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Arrays.asList("verb;build=строить", "noun;house=дом");
        assertEquals(expected, actual);
    }
}
