package com.blogspot.captain1653.dictionary.scala

import com.blogspot.captain1653.dictionary.scala.configreader.ConfFileRawConfigReader
import com.blogspot.captain1653.dictionary.scala.questionstrategy.QuestionStrategyFactory
import com.blogspot.captain1653.dictionary.scala.wordsreader.TextFileWordsReader
import com.blogspot.captain1653.dictionary.scala.wordsstream.WordsStreamFactory

import scala.io.StdIn

object Main {

  private val EXIT_VALUE = "exit"

  def main(args: Array[String]): Unit = {
    val configReader = new ConfFileRawConfigReader(args(0))
    val rawConfig = configReader.read()
    val rawConfigParser = new RawConfigParser(rawConfig)
    val dictionaryConfig = rawConfigParser.parse()

    val questionStrategy = QuestionStrategyFactory(dictionaryConfig.questionStrategyType)
    val filePathResolver = new FilePathResolver(dictionaryConfig)
    val wordsReader = new TextFileWordsReader(filePathResolver.absoluteFilePaths)
    val wordTypePredicate = WordsTypePredicate(dictionaryConfig.wordsType)
    val words = wordsReader.getWords(wordTypePredicate).map(line => new Word(line))
    val wordsStream = WordsStreamFactory(words, dictionaryConfig.order)

    var wordsWithMistakes: scala.collection.immutable.Set[String] = Set.empty[String]
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
