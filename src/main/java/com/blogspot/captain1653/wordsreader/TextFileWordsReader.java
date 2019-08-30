package com.blogspot.captain1653.wordsreader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.blogspot.captain1653.WordWithTranslation;

public class TextFileWordsReader implements WordsReader {

    @Override
    public Map<Integer, WordWithTranslation> getWords(String pathToFile) throws IOException {
        Scanner scanner = new Scanner( new File( pathToFile ) );
        Integer i = 1;
        Map<Integer, WordWithTranslation> words = new HashMap<>();
        while ( scanner.hasNextLine() ) {
            String lineWithWords = scanner.nextLine();
            WordWithTranslation wordWithTranslation = new WordWithTranslation( lineWithWords );
            words.put( i, wordWithTranslation );
            i++;
        }

        scanner.close();
        return words;
    }
}
