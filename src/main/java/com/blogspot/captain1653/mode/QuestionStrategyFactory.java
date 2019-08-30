package com.blogspot.captain1653.mode;

public class QuestionStrategyFactory {

    public QuestionStrategy create(String questionMode) {
        switch (questionMode) {
            case QuestionModeConstants.MIX: return new MixQuestionStrategy();
            case QuestionModeConstants.RU: return new RussianQuestionStrategy();
            default: return new EnglishQuestionStrategy();
        }
    }

    private static class QuestionModeConstants {
        private static final String RU = "ru";
        private static final String EN = "en";
        private static final String MIX = "mix";
    }
}
