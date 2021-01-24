package com.blogspot.captain1653.dictionary

import com.blogspot.captain1653.dictionary.config.{FilePathResolver, RawConfigParser}
import com.blogspot.captain1653.dictionary.config.reader.ConfFileRawConfigReader
import com.blogspot.captain1653.dictionary.dictionarysession.{ConsoleDictionarySession, DictionarySession}
import com.blogspot.captain1653.dictionary.questionstrategy.QuestionStrategyFactory
import com.blogspot.captain1653.dictionary.wordsreader.TextFileWordsReader
import com.blogspot.captain1653.dictionary.wordsstream.WordsStreamFactory

import java.io.{BufferedWriter, File, FileWriter}
import java.text.SimpleDateFormat
import java.util.Calendar

object Main {

  def main(args: Array[String]): Unit = {
    val configReader = new ConfFileRawConfigReader(args(0))
    val rawConfig = configReader.read()
    val rawConfigParser = new RawConfigParser(rawConfig)
    val dictionaryConfig = rawConfigParser.parse()
    val wordTypePredicate = WordsTypePredicate(dictionaryConfig.wordsType)
    val filePathResolver = new FilePathResolver(dictionaryConfig)
    val questionStrategy = QuestionStrategyFactory(dictionaryConfig.questionStrategyType)
    val wordsReader = new TextFileWordsReader(filePathResolver.absoluteFilePaths)

    val words = wordsReader.getWords(wordTypePredicate)
    val wordsStream = WordsStreamFactory(words, dictionaryConfig.order)

    val dictionarySession: DictionarySession = new ConsoleDictionarySession()
    val sessionResult = dictionarySession.start(wordsStream, questionStrategy)

    println(s"Count question is: ${sessionResult.countQuestions}")
    println(s"You have done ${sessionResult.mistakes.size} mistakes")
    if (sessionResult.mistakes.nonEmpty) println(s"Words are: ${sessionResult.mistakes.mkString(",  ")}")

    val fileName = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()) + ".txt"
    val filePath = "/home/andrey/Others/english/sessions/" + fileName;
    writeFile(filePath,sessionResult.mistakes)
  }

  def writeFile(filename: String, lines: Set[String]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    for (line <- lines) {
      bw.write(line + "\n")
    }
    bw.close()
  }

}
