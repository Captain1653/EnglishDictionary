package com.blogspot.captain1653.wordsstream;

import com.blogspot.captain1653.WordWithTranslation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceWordsStreamTest {

    @Test
    void getOneWord() {
        WordWithTranslation firstWord = new WordWithTranslation("house=дом");
        WordsStream wordsStream = new SequenceWordsStream(Collections.singletonList(firstWord));

        WordWithTranslation firstActual = wordsStream.nextWord();

        assertEquals("house", firstActual.getEnglish());
        assertEquals("дом", firstActual.getRussian());
    }

    @Test
    void getTwoWords() {
        WordWithTranslation firstWord = new WordWithTranslation("house=дом");
        WordWithTranslation secondWord = new WordWithTranslation("mouse=мышь");
        WordsStream wordsStream = new SequenceWordsStream(Arrays.asList(firstWord, secondWord));

        WordWithTranslation firstActual = wordsStream.nextWord();

        assertEquals("house", firstActual.getEnglish());
        assertEquals("дом", firstActual.getRussian());

        WordWithTranslation secondActual = wordsStream.nextWord();
        assertEquals("mouse", secondActual.getEnglish());
        assertEquals("мышь", secondActual.getRussian());
    }

    @Test
    void startInLoopAfterLastWord() {
        WordWithTranslation firstWord = new WordWithTranslation("house=дом");
        WordWithTranslation secondWord = new WordWithTranslation("mouse=мышь");
        WordsStream wordsStream = new SequenceWordsStream(Arrays.asList(firstWord, secondWord));

        WordWithTranslation firstActual = wordsStream.nextWord();

        assertEquals("house", firstActual.getEnglish());
        assertEquals("дом", firstActual.getRussian());

        WordWithTranslation secondActual = wordsStream.nextWord();
        assertEquals("mouse", secondActual.getEnglish());
        assertEquals("мышь", secondActual.getRussian());

        WordWithTranslation thirdActual = wordsStream.nextWord();

        assertEquals("house", thirdActual.getEnglish());
        assertEquals("дом", thirdActual.getRussian());
    }
}
