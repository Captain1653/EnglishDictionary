package com.blogspot.captain1653.dictionary.scala

import org.scalatest.funsuite.AnyFunSuite

class RawConfigParserSuite extends AnyFunSuite {

  test("parse WordsOrder from String") {
    val rawConfig = RawConfig("ru", Array(), "", "", order = "seq")
    val parser = new RawConfigParser(rawConfig)
    val dictionaryConfig = parser.parse();
    assert(WordsOrder.SEQUENTIAL == dictionaryConfig.order)
  }

  test("parse QuestionStrategyType.RUSSIAN from String") {
    val rawConfig = RawConfig("ru", Array(), "", "", order = "seq")
    val parser = new RawConfigParser(rawConfig)
    val dictionaryConfig = parser.parse()
    assert(QuestionStrategyType.RUSSIAN == dictionaryConfig.questionStrategyType)
  }

  test("parse QuestionStrategyType.ENGLISH from String") {
    val rawConfig = RawConfig("en", Array(), "", "", order = "seq")
    val parser = new RawConfigParser(rawConfig)
    val dictionaryConfig = parser.parse()
    assert(QuestionStrategyType.ENGLISH == dictionaryConfig.questionStrategyType)
  }

  test("parse QuestionStrategyType.MIX from String") {
    val rawConfig = RawConfig("mix", Array(), "", "", order = "seq")
    val parser = new RawConfigParser(rawConfig)
    val dictionaryConfig = parser.parse()
    assert(QuestionStrategyType.MIX == dictionaryConfig.questionStrategyType)
  }
}
