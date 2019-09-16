package com.blogspot.captain1653;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WordWithTranslationTest {

    @Test
    void splitOnEnglishAndRussianWordByCommaWithoutDescription() {
        String someString = "home=дом";
        WordWithTranslation wordWithTranslation = new WordWithTranslation(someString);

        assertEquals("home", wordWithTranslation.getEnglish());
        assertEquals("дом", wordWithTranslation.getRussian());
        assertNull(wordWithTranslation.getDescription());
    }

    @Test
    void returnDescriptionIfItExistAfterRussianWord() {
        String someString = "home=дом=description";
        WordWithTranslation wordWithTranslation = new WordWithTranslation(someString);

        assertEquals("home", wordWithTranslation.getEnglish());
        assertEquals("дом", wordWithTranslation.getRussian());
        assertEquals("description", wordWithTranslation.getDescription());
    }

}
