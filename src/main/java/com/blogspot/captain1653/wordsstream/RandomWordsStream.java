package com.blogspot.captain1653.wordsstream;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomWordsStream implements WordsStream {

    private Map<Integer, Word> words;

    public RandomWordsStream(List<Word> wordsWithTranslations) {
        this.words = new HashMap<>();
        int i = 1;
        for (Word word : wordsWithTranslations) {
            words.put(i, word);
            i++;
        }
    }

    @Override
    public Word nextWord() {
        return words.get(new Random(System.nanoTime()).nextInt(words.size()) + 1);
    }
}
