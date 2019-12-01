package com.blogspot.captain1653.wordsstream;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.List;

public class SequenceWordsStream implements WordsStream {

    private int currentWordIndex;
    private List<WordWithTranslation> wordWithTranslations;

    public SequenceWordsStream(List<WordWithTranslation> wordWithTranslations) {
        currentWordIndex = 0;
        this.wordWithTranslations = wordWithTranslations;
    }

    @Override
    public WordWithTranslation nextWord() {
        WordWithTranslation wordWithTranslation = wordWithTranslations.get(currentWordIndex);
        currentWordIndex++;
        if (currentWordIndex == wordWithTranslations.size()) {
            currentWordIndex = 0;
        }
        return wordWithTranslation;
    }
}
