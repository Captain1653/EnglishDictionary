package com.blogspot.captain1653.dictionary.questionstrategy


import com.blogspot.captain1653.dictionary.{QuestionStrategyType, Word}

import scala.util.Random

object QuestionStrategyFactory {

  def apply(questionStrategyType: QuestionStrategyType.Value): QuestionStrategy = questionStrategyType match {
    case QuestionStrategyType.RUSSIAN => new RussianQuestionStrategy()
    case QuestionStrategyType.MIX => new MixQuestionStrategy()
    case QuestionStrategyType.ENGLISH => new EnglishQuestionStrategy()
  }

  private class RussianQuestionStrategy extends QuestionStrategy {
    override def askQuestion(word: Word): String = word.russian.text
    override def getRightAnswer(word: Word): String = word.english.text
  }

  private class EnglishQuestionStrategy extends QuestionStrategy {
    override def askQuestion(word: Word): String = word.english.text
    override def getRightAnswer(word: Word): String = word.russian.text
  }

  private class MixQuestionStrategy extends QuestionStrategy {
    private var flag = false

    override def askQuestion(word: Word): String = {
      flag = new Random().nextBoolean()
      if (flag) word.english.text else word.russian.text
    }

    override def getRightAnswer(word: Word): String = {
      if (flag) word.russian.text else word.english.text
    }
  }
}


trait QuestionStrategy {
  def askQuestion(word: Word): String

  def getRightAnswer(word: Word): String
}
