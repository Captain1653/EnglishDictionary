package com.blogspot.captain1653.mode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionStrategyFactoryTest {

    private QuestionStrategyFactory questionStrategyFactory = new QuestionStrategyFactory();

    @Test
    void getMixQuestionStrategy() {
        QuestionStrategy questionStrategy = questionStrategyFactory.create("mix");
        assertEquals(MixQuestionStrategy.class, questionStrategy.getClass());
    }

    @Test
    void getRussianQuestionStrategy() {
        QuestionStrategy questionStrategy = questionStrategyFactory.create("ru");
        assertEquals(RussianQuestionStrategy.class, questionStrategy.getClass());
    }

    @Test
    void getEnglishQuestionStrategyByDefault() {
        QuestionStrategy questionStrategy = questionStrategyFactory.create("unkownStrategy");
        assertEquals(EnglishQuestionStrategy.class, questionStrategy.getClass());
    }
}
