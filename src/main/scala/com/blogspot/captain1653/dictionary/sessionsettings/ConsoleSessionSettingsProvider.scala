package com.blogspot.captain1653.dictionary.sessionsettings

import com.blogspot.captain1653.dictionary.questionstrategy.{QuestionStrategy, QuestionStrategyFactory}
import com.blogspot.captain1653.dictionary.wordmapper.DefaultStringWordMapper
import com.blogspot.captain1653.dictionary.{QuestionStrategyType, Word, WordType, WordsOrder}
import com.blogspot.captain1653.dictionary.wordsreader.TextFileWordsReader
import com.blogspot.captain1653.dictionary.wordsstream.{WordsStream, WordsStreamFactory}

import scala.io.StdIn

class ConsoleSessionSettingsProvider extends SessionSettingsProvider {

  override def sessionSettings(): SessionSettings = {
    println("Input paths separated by comma")
    val filePaths = StdIn.readLine().split(",")
    val wordsReader = new TextFileWordsReader(filePaths, new DefaultStringWordMapper())

    println("Words order: 1 - seq, 2 - rand")
    val wordsOrder = parseWordsOrder(StdIn.readLine())

    println("Input type of words: 1 - noun, 2 - adjective, 3 - adverb, 4 - verb, 5 - all")
    val wordPredicate = parseWordType(StdIn.readLine())
    val words = wordsReader.getWords(wordPredicate)

    println("Question Strategy: 1 - en, 2 - ru, 3 - mix")
    val questionStrategyType = parseQuestionStrategyType(StdIn.readLine())

    new SessionSettings {
      override def wordsStream(): WordsStream = WordsStreamFactory(words, wordsOrder)

      override def questionStrategy(): QuestionStrategy = QuestionStrategyFactory(questionStrategyType)
    }
  }

  private def parseWordsOrder(wordsOrder: String): WordsOrder.Value = wordsOrder match {
    case "1" => WordsOrder.SEQUENTIAL
    case "2" => WordsOrder.RANDOM
  }

  private def parseQuestionStrategyType(questionStrategy: String): QuestionStrategyType.Value = questionStrategy match {
    case "1" => QuestionStrategyType.ENGLISH
    case "2" => QuestionStrategyType.RUSSIAN
    case "3" => QuestionStrategyType.MIX
  }

  private def parseWordType(wordType: String): Word => Boolean = wordType match {
    case "1" => word => word.wordType == WordType.NOUN
    case "2" => word => word.wordType == WordType.ADJECTIVE
    case "3" => word => word.wordType == WordType.ADVERB
    case "4" => word => word.wordType == WordType.VERB
    case "5" => _ => true;
  }

}
