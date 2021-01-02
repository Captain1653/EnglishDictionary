package com.blogspot.captain1653.dictionary.scala.wordsreader

import scala.collection.mutable
import scala.io.Source

class TextFileWordsReader(absoluteFilePaths: Array[String]) extends WordsReader {

  private val DELIMITER_TYPE_WORD = ";"

  override def getWords(predicate: String => Boolean): List[String] = {
    val words: mutable.MutableList[String] = mutable.MutableList.empty[String]
    for(path <- absoluteFilePaths) {
      val file = Source.fromFile(path)
      words ++= file.getLines().filter(line => line.nonEmpty && predicate(line)).map(line => if (line.contains(DELIMITER_TYPE_WORD)) line.split(DELIMITER_TYPE_WORD)(1) else line).toList
      file.close()
    }
    words.toList
  }
}
