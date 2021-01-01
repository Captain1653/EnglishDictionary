package com.blogspot.captain1653.mode;

import com.blogspot.captain1653.dictionary.scala.Word;

public interface QuestionStrategy {

    String askQuestion(Word word);

    String getRightAnswer(Word word);
}
