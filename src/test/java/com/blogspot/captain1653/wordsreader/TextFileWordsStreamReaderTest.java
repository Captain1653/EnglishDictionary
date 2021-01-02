package com.blogspot.captain1653.wordsreader;

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
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader(new String[]{(TEST_RESOURCES + "wordsreader/readAllWords.txt")});
        List<String> actual = wordsReader.getWords(typeWordPredicate);

        List<String> expected = Arrays.asList("house=дом", "next=следующий");
        assertEquals(expected, actual);
    }

    @Test
    void readOnlyNounsByPredicate() throws IOException {
        Predicate<String> typeWordPredicate = line -> line.startsWith("noun");

        WordsReader wordsReader = new TextFileWordsReader(new String[]{TEST_RESOURCES + "wordsreader/readNouns.txt"});
        List<String> actual = wordsReader.getWords(typeWordPredicate);

        List<String> expected = Collections.singletonList("house=дом");
        assertEquals(expected, actual);
    }

    @Test
    void skipEmptyLinesFromFile() throws IOException {
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader(new String[]{TEST_RESOURCES + "wordsreader/skipEmptyLinesFromFile.txt"});
        List<String> actual = wordsReader.getWords(typeWordPredicate);

        List<String> expected = Arrays.asList("house=дом", "next=следующий");
        assertEquals(expected, actual);
    }

    @Disabled
    @Test
    void readAllFilesInTheFolderWhenPathToFilesIsStar() throws IOException {
        String folderWithFiles = TEST_RESOURCES + "wordsreader/readAllFilesInFolder/";
        Predicate<String> typeWordPredicate = line -> true;

        WordsReader wordsReader = new TextFileWordsReader(new String[]{folderWithFiles + "one.txt",folderWithFiles + "two.txt"});
        List<String> actual = wordsReader.getWords(typeWordPredicate);

        List<String> expected = Arrays.asList("build=строить", "house=дом");
        assertEquals(expected, actual);
    }
}
