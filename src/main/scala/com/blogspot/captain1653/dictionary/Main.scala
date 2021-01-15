package com.blogspot.captain1653.dictionary

import com.blogspot.captain1653.dictionary.config.{FilePathResolver, RawConfigParser}
import com.blogspot.captain1653.dictionary.config.reader.ConfFileRawConfigReader
import com.blogspot.captain1653.dictionary.questionstrategy.QuestionStrategyFactory
import com.blogspot.captain1653.dictionary.wordsreader.TextFileWordsReader
import com.blogspot.captain1653.dictionary.wordsstream.WordsStreamFactory

import scala.io.StdIn

object Main {

  private val EXIT_VALUE = "exit"

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
    var wordsWithMistakes: Set[String] = Set.empty[String]
    var countQuestion = 0

    var isContinueLoop = true
    while (isContinueLoop) {
      val word = wordsStream.nextWord()
      val question = questionStrategy.askQuestion(word)
      println("Word: " + question)

      val answerFromUser = StdIn.readLine()
      val rightAnswer = questionStrategy.getRightAnswer(word)

      if (EXIT_VALUE == answerFromUser) {
        println(s"Count question is: $countQuestion")
        val countMistakes = wordsWithMistakes.size
        println(s"You have done $countMistakes mistakes")
        if (countMistakes > 0) println(s"Words are: ${wordsWithMistakes.mkString(",  ")}")
        isContinueLoop = false
      } else {
        if (rightAnswer.equalsIgnoreCase(answerFromUser)) {
          println("TRUE")
        } else {
          println(s"NO!!!!!! Answer is $rightAnswer")
          wordsWithMistakes += rightAnswer
        }
        countQuestion += 1
      }
    }
  }

}
