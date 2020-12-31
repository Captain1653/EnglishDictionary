package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.Scanner;

public class EnglishQuestionStrategy implements QuestionStrategy {
    @Override
    public String askQuestion(Scanner scanner, Word word) {
        String description = word.description() == null ? "" : "Description: " + word.description();
        System.out.println("Word: " + word.english() + " " + description);
        return scanner.nextLine();

    }

    @Override
    public String getRightAnswer(Word wordWithTranslation) {
        return wordWithTranslation.russian();
    }
}
