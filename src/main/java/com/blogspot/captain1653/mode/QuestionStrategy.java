package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.Scanner;

public interface QuestionStrategy {

    String askQuestion(Scanner scanner, WordWithTranslation wordWithTranslation);

    String getRightAnswer(WordWithTranslation wordWithTranslation);
}
