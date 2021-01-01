package com.blogspot.captain1653.wordsreader;

import com.blogspot.captain1653.dictionary.scala.DictionaryConfig;
import org.junit.jupiter.api.Disabled;
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
        DictionaryConfig configuration = getConfigurationWithPathFile(pathToFile, TEST_RESOURCES);
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Arrays.asList("house=дом", "next=следующий");
        assertEquals(expected, actual);
    }

    private DictionaryConfig getConfigurationWithPathFile(String pathToFile, String folderForFiles) {
        return new DictionaryConfig(
                "", new String[]{pathToFile}, "", folderForFiles, ""
        );
    }

    @Test
    void readOnlyNounsByPredicate() throws IOException {
        String pathToFile = "wordsreader/readNouns.txt";
        DictionaryConfig configuration = getConfigurationWithPathFile(pathToFile, TEST_RESOURCES);
        Predicate<String> typeWordPredicate = line -> line.startsWith("noun");

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Collections.singletonList("house=дом");
        assertEquals(expected, actual);
    }

    @Test
    void skipEmptyLinesFromFile() throws IOException {
        String pathToFile = "wordsreader/skipEmptyLinesFromFile.txt";
        DictionaryConfig configuration = getConfigurationWithPathFile(pathToFile, TEST_RESOURCES);
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Arrays.asList("house=дом", "next=следующий");
        assertEquals(expected, actual);
    }

    @Disabled
    @Test
    void readAllFilesInTheFolderWhenPathToFilesIsStar() throws IOException {
        String pathToFile = "*";
        String folderWithFiles = TEST_RESOURCES + "wordsreader/readAllFilesInFolder/";
        DictionaryConfig configuration = getConfigurationWithPathFile(pathToFile, folderWithFiles);
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader();
        List<String> actual = wordsReader.getWords(configuration, typeWordPredicate);

        List<String> expected = Arrays.asList("build=строить", "house=дом");
        assertEquals(expected, actual);
    }
}
