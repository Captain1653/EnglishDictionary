package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.Random;
import java.util.Scanner;

public class MixQuestionStrategy implements QuestionStrategy {

    private Boolean flag;

    public MixQuestionStrategy() {
        this.flag = false;
    }

    @Override
    public String askQuestion(Scanner scanner, WordWithTranslation wordWithTranslation) {
        flag = new Random().nextBoolean();
        String word = flag ? wordWithTranslation.getEnglish() : wordWithTranslation.getRussian();
        String description = wordWithTranslation.getDescription() == null ? null : "Desctiption: " + wordWithTranslation.getDescription();
        System.out.println("Word: " + word + " " + description);
        return scanner.nextLine();
    }

    @Override
    public String getRightAnswer(WordWithTranslation wordWithTranslation) {
        return flag ? wordWithTranslation.getRussian() : wordWithTranslation.getEnglish();
    }
}
