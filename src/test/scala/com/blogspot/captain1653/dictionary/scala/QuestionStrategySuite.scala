package com.blogspot.captain1653.dictionary.scala

import com.blogspot.captain1653.dictionary.scala.questionstrategy.QuestionStrategyFactory
import org.scalatest.funsuite.AnyFunSuite

class QuestionStrategySuite extends AnyFunSuite {

  test("ask question and give answer RussianQuestionStrategy") {
    val questionStrategy = QuestionStrategyFactory.apply(QuestionStrategyType.RUSSIAN)
    val word = new Word("house=дом")
    assert("дом" == questionStrategy.askQuestion(word))
    assert("house" == questionStrategy.getRightAnswer(word))
  }

  test("ask question and give answer EnglishQuestionStrategy") {
    val questionStrategy = QuestionStrategyFactory.apply(QuestionStrategyType.ENGLISH)
    val word = new Word("house=дом")
    assert("house" == questionStrategy.askQuestion(word))
    assert("дом" == questionStrategy.getRightAnswer(word))
  }
}
