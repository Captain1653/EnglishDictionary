package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.Random;
import java.util.Scanner;

public class MixQuestionStrategy implements QuestionStrategy {

    private Boolean flag;

    public MixQuestionStrategy() {
        this.flag = false;
    }

    @Override
    public String askQuestion(Scanner scanner, Word wordWithTranslation) {
        flag = new Random().nextBoolean();
        String word = flag ? wordWithTranslation.english() : wordWithTranslation.russian();
        String description = wordWithTranslation.description() == null ? "" : "Description: " + wordWithTranslation.description();
        System.out.println("Word: " + word + " " + description);
        return scanner.nextLine();
    }

    @Override
    public String getRightAnswer(Word wordWithTranslation) {
        return flag ? wordWithTranslation.russian() : wordWithTranslation.english();
    }
}
