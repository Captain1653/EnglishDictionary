package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.Scanner;

public interface QuestionStrategy {

    String askQuestion(Scanner scanner, Word word);

    String getRightAnswer(Word word);
}
