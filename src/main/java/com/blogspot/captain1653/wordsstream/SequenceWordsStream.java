package com.blogspot.captain1653.wordsstream;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.List;

public class SequenceWordsStream implements WordsStream {

    private int currentWordIndex;
    private List<Word> wordWithTranslations;

    public SequenceWordsStream(List<Word> wordWithTranslations) {
        currentWordIndex = 0;
        this.wordWithTranslations = wordWithTranslations;
    }

    @Override
    public Word nextWord() {
        Word wordWithTranslation = wordWithTranslations.get(currentWordIndex);
        currentWordIndex++;
        if (currentWordIndex == wordWithTranslations.size()) {
            currentWordIndex = 0;
        }
        return wordWithTranslation;
    }
}
