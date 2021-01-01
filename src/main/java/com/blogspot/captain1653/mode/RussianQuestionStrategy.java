package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

public class RussianQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(Word word) {
        return word.russian();
    }

    @Override
    public String getRightAnswer(Word word) {
        return word.english();
    }
}
