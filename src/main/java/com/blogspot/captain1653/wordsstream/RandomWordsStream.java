package com.blogspot.captain1653.wordsstream;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomWordsStream implements WordsStream {

    private Map<Integer,WordWithTranslation> words;

    public RandomWordsStream(List<WordWithTranslation> wordsWithTranslations) {
        this.words = new HashMap<>();
        int i = 1;
        for (WordWithTranslation word : wordsWithTranslations) {
            words.put(i, word);
        }
    }

    @Override
    public WordWithTranslation nextWord() {
        return words.get(new Random(System.nanoTime()).nextInt(words.size()) + 1);
    }
}
