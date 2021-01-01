package com.blogspot.captain1653.dictionary.scala.questionstrategy

import com.blogspot.captain1653.dictionary.scala.Word

import scala.util.Random

object QuestionStrategyFactory {

  def apply(questionStrategy: String): QuestionStrategy = questionStrategy match {
    case "ru" => new RussianQuestionStrategy()
    case "mix" => new MixQuestionStrategy()
    case "en" => new EnglishQuestionStrategy()
  }

  private class RussianQuestionStrategy extends QuestionStrategy {
    override def askQuestion(word: Word): String = word.russian
    override def getRightAnswer(word: Word): String = word.english
  }

  private class EnglishQuestionStrategy extends QuestionStrategy {
    override def askQuestion(word: Word): String = word.english
    override def getRightAnswer(word: Word): String = word.russian
  }

  private class MixQuestionStrategy extends QuestionStrategy {
    private var flag = false

    override def askQuestion(word: Word): String = {
      flag = new Random().nextBoolean()
      if (flag) word.english else word.russian
    }

    override def getRightAnswer(word: Word): String = {
      if (flag) word.russian else word.english
    }
  }
}


trait QuestionStrategy {
  def askQuestion(word: Word): String

  def getRightAnswer(word: Word): String
}
