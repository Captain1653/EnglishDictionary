package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.WordWithTranslation;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SimpleWordsStreamCreatorTest {

    @Test
    void createWordsWithTranslationWithoutDescription() {
        List<String> lines = Collections.singletonList("verb;play=играть");
        WordsCreator wordsCreator = new SimpleWordsCreator();
        List<WordWithTranslation> words = wordsCreator.create(lines);

        WordWithTranslation word = words.get(0);
        assertEquals("play", word.getEnglish());
        assertEquals("играть", word.getRussian());
        assertNull(word.getDescription());
    }

    @Test
    void createWordsWithTranslationWithDescription() {
        List<String> lines = Collections.singletonList("verb;do=делать=description");
        WordsCreator wordsCreator = new SimpleWordsCreator();
        List<WordWithTranslation> words = wordsCreator.create(lines);

        WordWithTranslation word = words.get(0);
        assertEquals("do", word.getEnglish());
        assertEquals("делать", word.getRussian());
        assertEquals("description", word.getDescription());
    }

    @Test
    void createWordsWithTranslationWithoutTypeWord() {
        List<String> lines = Collections.singletonList("do=делать=description");
        WordsCreator wordsCreator = new SimpleWordsCreator();
        List<WordWithTranslation> words = wordsCreator.create(lines);

        WordWithTranslation word = words.get(0);
        assertEquals("do", word.getEnglish());
        assertEquals("делать", word.getRussian());
        assertEquals("description", word.getDescription());
    }
}
