package com.blogspot.captain1653.dictionary.dictionarysession

import com.blogspot.captain1653.dictionary.SessionResult
import com.blogspot.captain1653.dictionary.sessionsettings.SessionSettings

trait DictionarySession {

  private val EXIT_VALUE = "exit"

  private[dictionarysession] def askQuestion(question: String): Unit

  private[dictionarysession] def readAnswer(): String

  private[dictionarysession] def showSuccessMessage(): Unit

  private[dictionarysession] def showWrongMessage(rightAnswer: String): Unit

  def start(sessionSettings: SessionSettings): SessionResult = {
    var isContinueLoop = true
    var countQuestions = 0
    var wordsWithMistakes: Set[String] = Set.empty[String]
    val wordsStream = sessionSettings.wordsStream()
    val questionStrategy = sessionSettings.questionStrategy()
    while (isContinueLoop) {
      val word = wordsStream.nextWord()
      val question = questionStrategy.askQuestion(word)
      askQuestion(question)

      val answerFromUser = readAnswer()
      val rightAnswer = questionStrategy.getRightAnswer(word)

      if (EXIT_VALUE == answerFromUser) {
        isContinueLoop = false
      } else {
        if (rightAnswer.equalsIgnoreCase(answerFromUser)) {
          showSuccessMessage()
        } else {
          showWrongMessage(rightAnswer)
          wordsWithMistakes += rightAnswer
        }
        countQuestions += 1
      }
    }
    new SessionResult(countQuestions, wordsWithMistakes)
  }
}
