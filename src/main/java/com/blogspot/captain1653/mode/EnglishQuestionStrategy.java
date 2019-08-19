package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.Scanner;

public class EnglishQuestionStrategy implements QuestionStrategy {
    @Override
    public String askQuestion(Scanner scanner, WordWithTranslation wordWithTranslation) {
        String description = wordWithTranslation.getDescription() == null ? null : "Desctiption: " + wordWithTranslation.getDescription();
        System.out.print("Word: " + wordWithTranslation.getEnglish() + " " + description);
        return scanner.nextLine();

    }

    @Override
    public String getRightAnswer(WordWithTranslation wordWithTranslation) {
        return wordWithTranslation.getRussian();
    }
}
