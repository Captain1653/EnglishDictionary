package com.blogspot.captain1653.dictionary.wordsreader

import com.blogspot.captain1653.dictionary.Word
import com.blogspot.captain1653.dictionary.wordmapper.StringWordMapper

import scala.collection.mutable
import scala.io.Source

class TextFileWordsReader(absoluteFilePaths: Array[String], stringWordMapper: StringWordMapper) extends WordsReader {


  override def getWords(predicate: String => Boolean): List[Word] = {
    val words = mutable.MutableList.empty[Word]
    for(path <- absoluteFilePaths) {
      val file = Source.fromFile(path)
      words ++= file.getLines().filter(line => line.nonEmpty && predicate(line))
                              .map(line => stringWordMapper.map(line))
                              .toList
      file.close()
    }
    words.toList
  }
}
