package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

public class EnglishQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(Word word) {
        return word.english();

    }

    @Override
    public String getRightAnswer(Word word) {
        return word.russian();
    }
}
