package com.blogspot.captain1653.dictionary.config

import com.blogspot.captain1653.dictionary.{QuestionStrategyType, WordSearchCriteria, WordType, WordsOrder}
import org.scalatest.funsuite.AnyFunSuite

class RawConfigParserSuite extends AnyFunSuite {

  test("parse WordsOrder from String") {
    val rawConfig = RawConfig("ru", "pathFiles", "noun", "", order = "seq")
    assert(WordsOrder.SEQUENTIAL == parseRawConfig(rawConfig).order)
  }

  private def parseRawConfig(rawConfig: RawConfig) = {
    val parser = new RawConfigParser(rawConfig)
    parser.parse()
  }

  test("parse QuestionStrategyType.RUSSIAN from String") {
    val rawConfig = RawConfig("ru", "pathFiles", "noun", "", order = "seq")
    assert(QuestionStrategyType.RUSSIAN == parseRawConfig(rawConfig).questionStrategyType)
  }

  test("parse QuestionStrategyType.ENGLISH from String") {
    val rawConfig = RawConfig("en", "pathFiles", "noun", "", order = "seq")
    assert(QuestionStrategyType.ENGLISH == parseRawConfig(rawConfig).questionStrategyType)
  }

  test("parse QuestionStrategyType.MIX from String") {
    val rawConfig = RawConfig("mix", "pathFiles", "noun", "", order = "seq")
    assert(QuestionStrategyType.MIX == parseRawConfig(rawConfig).questionStrategyType)
  }

  test("parse WordsType.NOUN from String") {
    val rawConfig = RawConfig("ru", "pathFiles", "noun", "", order = "seq")
    assert(WordSearchCriteria("noun", WordType.NOUN) == parseRawConfig(rawConfig).wordsType)
  }

  test("parse WordsType.VERB from String") {
    val rawConfig = RawConfig("ru", "pathFiles", "verb", "", order = "seq")
    assert(WordSearchCriteria("verb", WordType.VERB) == parseRawConfig(rawConfig).wordsType)
  }

  test("parse WordsType.ADJECTIVE from String") {
    val rawConfig = RawConfig("ru", "pathFiles", "adjective", "", order = "seq")
    assert(WordSearchCriteria("adjective", WordType.ADJECTIVE) == parseRawConfig(rawConfig).wordsType)
  }

  test("parse WordsType.ADVERB from String") {
    val rawConfig = RawConfig("ru", "pathFiles", "adverb", "", order = "seq")
    assert(WordSearchCriteria("adverb", WordType.ADVERB) == parseRawConfig(rawConfig).wordsType)
  }

  test("parse copy {folder} parameter ") {
    val rawConfig = RawConfig("ru", "pathFiles", "adverb", "folder", order = "seq")
    assert("folder" == parseRawConfig(rawConfig).folder)
  }

  test("split files by comma") {
    val rawConfig = RawConfig("ru", "one.txt,two.txt", "adverb", "folder", order = "seq")
    assert(Array("one.txt", "two.txt") sameElements parseRawConfig(rawConfig).files)
  }
}
