package com.blogspot.captain1653.dictionary.wordsreader

trait WordsReader {
  def getWords(predicate: String => Boolean): List[String]

}
