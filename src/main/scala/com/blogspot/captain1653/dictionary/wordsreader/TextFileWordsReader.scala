package com.blogspot.captain1653.dictionary.wordsreader

import com.blogspot.captain1653.dictionary.{English, Russian, Word}

import scala.collection.mutable
import scala.io.Source

class TextFileWordsReader(absoluteFilePaths: Array[String]) extends WordsReader {

  private val DELIMITER_TYPE_WORD = ";"
  private val PARTS_WORD_DELIMITER = "="

  override def getWords(predicate: String => Boolean): List[Word] = {
    val words = mutable.MutableList.empty[Word]
    for(path <- absoluteFilePaths) {
      val file = Source.fromFile(path)
      words ++= file.getLines().filter(line => line.nonEmpty && predicate(line))
                              .map(line => if (line.contains(DELIMITER_TYPE_WORD)) line.split(DELIMITER_TYPE_WORD)(1) else line)
                              .map(mapLineToWord)
                              .toList
      file.close()
    }
    words.toList
  }

  private def mapLineToWord(line: String): Word = line.split(PARTS_WORD_DELIMITER) match {
    case Array(english, russian, description) => Word(new English(english), new Russian(russian), Some(description))
    case Array(english, russian) => Word(new English(english), new Russian(russian))
  }
}
