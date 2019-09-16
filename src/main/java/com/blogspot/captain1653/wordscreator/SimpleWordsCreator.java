package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleWordsCreator implements WordsCreator {

    private static final String DELIMITER_TYPE_WORD = ";";

    @Override
    public Map<Integer, WordWithTranslation> create(List<String> lines) {
        Map<Integer, WordWithTranslation> words = new HashMap<>();
        int i = 1;

        for (String line : lines) {
            String englishAndRussianWords = line.split(DELIMITER_TYPE_WORD)[1];
            WordWithTranslation wordWithTranslation = new WordWithTranslation(englishAndRussianWords);
            words.put(i, wordWithTranslation);
            i++;
        }

        return words;
    }
}
