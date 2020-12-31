package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.Scanner;

public class RussianQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(Scanner scanner, Word word) {
        String description = word.description() == null ? "" : "Desctiption: " + word.description();
        System.out.println("Word: " + word.russian() + " " + description);
        return scanner.nextLine();
    }

    @Override
    public String getRightAnswer(Word word) {
        return word.english();
    }
}
