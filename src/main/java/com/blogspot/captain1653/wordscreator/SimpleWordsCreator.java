package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.ArrayList;
import java.util.List;

public class SimpleWordsCreator implements WordsCreator {

    private static final String DELIMITER_TYPE_WORD = ";";

    @Override
    public List<WordWithTranslation> create(List<String> lines) {
        List<WordWithTranslation> words = new ArrayList<>();
        for (String line : lines) {
            String englishAndRussianWords;
            if (line.contains(DELIMITER_TYPE_WORD)) {
                englishAndRussianWords = line.split(DELIMITER_TYPE_WORD)[1];
            } else {
                englishAndRussianWords = line;
            }
            WordWithTranslation wordWithTranslation = new WordWithTranslation(englishAndRussianWords);
            words.add(wordWithTranslation);
        }

        return words;
    }
}
