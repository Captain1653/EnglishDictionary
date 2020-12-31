package com.blogspot.captain1653.wordsstream;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.List;

public class WordsStreamFactory {

    private static final String SEQUENCE_ORDER = "seq";

    public WordsStream get(List<Word> words, String order) {
        if (SEQUENCE_ORDER.equals(order)) {
            return new SequenceWordsStream(words);
        } else {
            return new RandomWordsStream(words);
        }
    }
}
