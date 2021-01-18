package com.blogspot.captain1653.dictionary.dictionarysession

import scala.io.StdIn

class ConsoleDictionarySession extends DictionarySession {

  override def askQuestion(question: String): Unit = {
    println("Word: " + question)
  }

  override def readAnswer(): String = {
    StdIn.readLine()
  }

  override def showSuccessMessage(): Unit = {
    println("TRUE")
  }

  override def showWrongMessage(rightAnswer: String): Unit = {
    println(s"NO!!!!!! Answer is $rightAnswer")
  }
}
