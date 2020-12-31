package com.blogspot.captain1653.wordsstream;

import com.blogspot.captain1653.dictionary.scala.Word;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceWordsStreamTest {

    @Test
    void getOneWord() {
        Word firstWord = new Word("house=дом");
        WordsStream wordsStream = new SequenceWordsStream(Collections.singletonList(firstWord));

        Word firstActual = wordsStream.nextWord();

        assertEquals("house", firstActual.english());
        assertEquals("дом", firstActual.russian());
    }

    @Test
    void getTwoWords() {
        Word firstWord = new Word("house=дом");
        Word secondWord = new Word("mouse=мышь");
        WordsStream wordsStream = new SequenceWordsStream(Arrays.asList(firstWord, secondWord));

        Word firstActual = wordsStream.nextWord();

        assertEquals("house", firstActual.english());
        assertEquals("дом", firstActual.russian());

        Word secondActual = wordsStream.nextWord();
        assertEquals("mouse", secondActual.english());
        assertEquals("мышь", secondActual.russian());
    }

    @Test
    void startInLoopAfterLastWord() {
        Word firstWord = new Word("house=дом");
        Word secondWord = new Word("mouse=мышь");
        WordsStream wordsStream = new SequenceWordsStream(Arrays.asList(firstWord, secondWord));

        Word firstActual = wordsStream.nextWord();

        assertEquals("house", firstActual.english());
        assertEquals("дом", firstActual.russian());

        Word secondActual = wordsStream.nextWord();
        assertEquals("mouse", secondActual.english());
        assertEquals("мышь", secondActual.russian());

        Word thirdActual = wordsStream.nextWord();

        assertEquals("house", thirdActual.english());
        assertEquals("дом", thirdActual.russian());
    }
}
