package com.blogspot.captain1653.wordsreader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.WordWithTranslation;

public class TextFileWordsReader implements WordsReader {

    private static final String DELIMITER_TYPE_WORD = ";";
    @Override
    public Map<Integer, WordWithTranslation> getWords(Configuration configuration, Predicate<String> typeWordPredicate) throws IOException {
        Map<Integer, WordWithTranslation> words = new HashMap<>();
        Integer i = 1;
        String folderForFiles = configuration.getFolderForFiles();
        for (String path : configuration.getPathFiles()) {
            String fullPathToFile = folderForFiles + path;
            Scanner scanner = new Scanner(new File(fullPathToFile));
            while (scanner.hasNextLine()) {
                String lineWithWords = scanner.nextLine();
                if (typeWordPredicate.test(lineWithWords)) {
                    String[] typeAndWordWithTranslation = lineWithWords.split(DELIMITER_TYPE_WORD);
                    WordWithTranslation wordWithTranslation = new WordWithTranslation(typeAndWordWithTranslation[1]);
                    words.put(i, wordWithTranslation);
                    i++;
                }
            }

            scanner.close();
        }
        return words;
    }
}
