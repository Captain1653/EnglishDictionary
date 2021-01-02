package com.blogspot.captain1653.dictionary.config

import com.blogspot.captain1653.dictionary.{QuestionStrategyType, WordSearchCriteria, WordsOrder}

case class DictionaryConfig(
                             order: WordsOrder.Value,
                             questionStrategyType: QuestionStrategyType.Value,
                             folder: String,
                             files: Array[String],
                             wordsType: WordSearchCriteria
                           )
