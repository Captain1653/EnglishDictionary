package com.blogspot.captain1653.dictionary.wordsreader

import com.blogspot.captain1653.dictionary.Word

trait WordsReader {
  def getWords(predicate: Word => Boolean): List[Word]

}
