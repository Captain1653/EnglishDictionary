package com.blogspot.captain1653.dictionary.config

import com.blogspot.captain1653.dictionary.{QuestionStrategyType, WordSearchCriteria, WordType, WordsOrder}


class RawConfigParser(rawConfig: RawConfig) {

  def parse(): DictionaryConfig = {
    DictionaryConfig(
      order = parseWordsOrder(rawConfig.order),
      questionStrategyType = parseQuestionStrategy(rawConfig.questionStrategy),
      folder = rawConfig.folderForFiles,
      files = rawConfig.pathFiles.split(","),
      wordsType = parseWordType(rawConfig.wordType)
    )
  }

  private def parseWordsOrder(wordsOrder: String): WordsOrder.Value = wordsOrder match {
    case "seq" => WordsOrder.SEQUENTIAL
    case "rand" => WordsOrder.RANDOM
  }

  private def parseQuestionStrategy(questionStrategy: String): QuestionStrategyType.Value = questionStrategy match {
    case "ru" => QuestionStrategyType.RUSSIAN
    case "en" => QuestionStrategyType.ENGLISH
    case "mix" => QuestionStrategyType.MIX
  }

  private def parseWordType(wordType: String): WordSearchCriteria = wordType match {
    case "noun" => WordSearchCriteria("noun", WordType.NOUN)
    case "verb" => WordSearchCriteria("verb", WordType.VERB)
    case "adjective" => WordSearchCriteria("adjective", WordType.ADJECTIVE)
    case "adverb" => WordSearchCriteria("adverb", WordType.ADVERB)
  }

}
