package com.blogspot.captain1653.wordsstream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsStreamFactoryTest {

    @Test
    void getRandomWords() {
        WordsStreamFactory wordsStreamFactory = new WordsStreamFactory();
        WordsStream wordsStream = wordsStreamFactory.get(new ArrayList<>(), "rand");

        assertEquals(RandomWordsStream.class, wordsStream.getClass());
    }

    @Test
    void getSequenceWords() {
        WordsStreamFactory wordsStreamFactory = new WordsStreamFactory();
        WordsStream wordsStream = wordsStreamFactory.get(new ArrayList<>(), "seq");

        assertEquals(SequenceWordsStream.class, wordsStream.getClass());
    }
}
