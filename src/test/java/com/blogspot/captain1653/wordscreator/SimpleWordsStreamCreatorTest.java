package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.dictionary.scala.Word;
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
        List<Word> words = wordsCreator.create(lines);

        Word word = words.get(0);
        assertEquals("play", word.english());
        assertEquals("играть", word.russian());
        assertNull(word.description());
    }

    @Test
    void createWordsWithTranslationWithDescription() {
        List<String> lines = Collections.singletonList("verb;do=делать=description");
        WordsCreator wordsCreator = new SimpleWordsCreator();
        List<Word> words = wordsCreator.create(lines);

        Word word = words.get(0);
        assertEquals("do", word.english());
        assertEquals("делать", word.russian());
        assertEquals("description", word.description());
    }

    @Test
    void createWordsWithTranslationWithoutTypeWord() {
        List<String> lines = Collections.singletonList("do=делать=description");
        WordsCreator wordsCreator = new SimpleWordsCreator();
        List<Word> words = wordsCreator.create(lines);

        Word word = words.get(0);
        assertEquals("do", word.english());
        assertEquals("делать", word.russian());
        assertEquals("description", word.description());
    }
}
