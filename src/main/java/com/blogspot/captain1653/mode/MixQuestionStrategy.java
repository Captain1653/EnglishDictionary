package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.Random;

public class MixQuestionStrategy implements QuestionStrategy {

    private Boolean flag;

    public MixQuestionStrategy() {
        this.flag = false;
    }

    @Override
    public String askQuestion(Word wordWithTranslation) {
        flag = new Random().nextBoolean();
        return flag ? wordWithTranslation.english() : wordWithTranslation.russian();
    }

    @Override
    public String getRightAnswer(Word wordWithTranslation) {
        return flag ? wordWithTranslation.russian() : wordWithTranslation.english();
    }
}
