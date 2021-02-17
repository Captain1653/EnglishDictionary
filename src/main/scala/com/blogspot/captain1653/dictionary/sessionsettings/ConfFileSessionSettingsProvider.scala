package com.blogspot.captain1653.dictionary.sessionsettings

import com.blogspot.captain1653.dictionary.WordsTypePredicate
import com.blogspot.captain1653.dictionary.config.{FilePathResolver, RawConfigParser}
import com.blogspot.captain1653.dictionary.config.reader.ConfFileRawConfigReader
import com.blogspot.captain1653.dictionary.questionstrategy.{QuestionStrategy, QuestionStrategyFactory}
import com.blogspot.captain1653.dictionary.wordmapper.DefaultStringWordMapper
import com.blogspot.captain1653.dictionary.wordsreader.TextFileWordsReader
import com.blogspot.captain1653.dictionary.wordsstream.{WordsStream, WordsStreamFactory}

import scala.io.StdIn

class ConfFileSessionSettingsProvider extends SessionSettingsProvider {

  override def sessionSettings(): SessionSettings = {
    println("Input path to *.conf file")
    val confFilePath = StdIn.readLine()

    val configReader = new ConfFileRawConfigReader(confFilePath)
    val rawConfig = configReader.read()
    val rawConfigParser = new RawConfigParser(rawConfig)
    val dictionaryConfig = rawConfigParser.parse()
    val wordTypePredicate = WordsTypePredicate(dictionaryConfig.wordsType)
    val filePathResolver = new FilePathResolver(dictionaryConfig)
    val wordsReader = new TextFileWordsReader(filePathResolver.absoluteFilePaths, new DefaultStringWordMapper())
    val words = wordsReader.getWords(wordTypePredicate)

    new SessionSettings {
      override def wordsStream(): WordsStream = WordsStreamFactory(words, dictionaryConfig.order)

      override def questionStrategy(): QuestionStrategy = QuestionStrategyFactory(dictionaryConfig.questionStrategyType)
    }

  }
}
