package com.blogspot.captain1653.dictionary.scala

import com.blogspot.captain1653.dictionary.scala.WordsOrder.{RANDOM, SEQUENTIAL}

class RawConfigParser(rawConfig: RawConfig) {

  private val SEQUENTIAL_WORDS_ORDER = "seq"

  def parse(): DictionaryConfig = {
    DictionaryConfig(
      order = if (SEQUENTIAL_WORDS_ORDER == rawConfig.order) SEQUENTIAL else RANDOM,
      questionStrategyType = parseQuestionStrategy(rawConfig.questionStrategy),
      folder = rawConfig.folderForFiles,
      files = rawConfig.pathFiles
    )
  }

  private def parseQuestionStrategy(questionStrategy: String): QuestionStrategyType.Value = questionStrategy match {
    case "ru" => QuestionStrategyType.RUSSIAN
    case "en" => QuestionStrategyType.ENGLISH
    case "mix" => QuestionStrategyType.MIX
  }


}
