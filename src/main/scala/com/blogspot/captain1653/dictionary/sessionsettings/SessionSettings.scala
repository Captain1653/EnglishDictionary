package com.blogspot.captain1653.dictionary.sessionsettings

import com.blogspot.captain1653.dictionary.questionstrategy.QuestionStrategy
import com.blogspot.captain1653.dictionary.wordsstream.WordsStream

trait SessionSettings {

  def wordsStream(): WordsStream

  def questionStrategy(): QuestionStrategy
}
