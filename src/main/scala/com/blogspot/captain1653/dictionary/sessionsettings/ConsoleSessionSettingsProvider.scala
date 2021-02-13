package com.blogspot.captain1653.dictionary.sessionsettings

import com.blogspot.captain1653.dictionary.questionstrategy.{QuestionStrategy, QuestionStrategyFactory}
import com.blogspot.captain1653.dictionary.{QuestionStrategyType, WordSearchCriteria, WordType, WordsOrder, WordsTypePredicate}
import com.blogspot.captain1653.dictionary.wordsreader.TextFileWordsReader
import com.blogspot.captain1653.dictionary.wordsstream.{WordsStream, WordsStreamFactory}

import scala.io.StdIn

class ConsoleSessionSettingsProvider extends SessionSettingsProvider {

  override def sessionSettings(): SessionSettings = {
    println("Input paths separated by comma")
    val filePaths = StdIn.readLine().split(",")
    val wordsReader = new TextFileWordsReader(filePaths)

    println("Words order: seq, rand")
    val wordsOrder = parseWordsOrder(StdIn.readLine())

    println("Input type of words: noun, adjective, adverb, verb, all")
    val wordTypePredicate = WordsTypePredicate(parseWordType(StdIn.readLine()))
    val words = wordsReader.getWords(wordTypePredicate)

    println("Question Strategy: en, ru, mix")
    val questionStrategyType = parseQuestionStrategyType(StdIn.readLine())

    new SessionSettings {
      override def wordsStream(): WordsStream = WordsStreamFactory(words, wordsOrder)

      override def questionStrategy(): QuestionStrategy = QuestionStrategyFactory(questionStrategyType)
    }
  }

  private def parseWordsOrder(wordsOrder: String): WordsOrder.Value = wordsOrder match {
    case "seq" => WordsOrder.SEQUENTIAL
    case "rand" => WordsOrder.RANDOM
  }

  private def parseQuestionStrategyType(questionStrategy: String): QuestionStrategyType.Value = questionStrategy match {
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
