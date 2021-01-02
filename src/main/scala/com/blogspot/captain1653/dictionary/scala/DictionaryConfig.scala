package com.blogspot.captain1653.dictionary.scala

case class DictionaryConfig(
                           order: WordsOrder.Value,
                           questionStrategyType: QuestionStrategyType.Value,
                           folder: String,
                           files: Array[String],
                           wordsType: WordSearchCriteria
                           )
