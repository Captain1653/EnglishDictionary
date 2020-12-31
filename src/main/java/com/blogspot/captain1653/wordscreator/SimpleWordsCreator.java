package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.ArrayList;
import java.util.List;

public class SimpleWordsCreator implements WordsCreator {

    private static final String DELIMITER_TYPE_WORD = ";";

    @Override
    public List<Word> create(List<String> lines) {
        List<Word> words = new ArrayList<>();
        for (String line : lines) {
            String englishAndRussianWords;
            if (line.contains(DELIMITER_TYPE_WORD)) {
                englishAndRussianWords = line.split(DELIMITER_TYPE_WORD)[1];
            } else {
                englishAndRussianWords = line;
            }
            words.add(new Word(englishAndRussianWords));
        }

        return words;
    }
}
