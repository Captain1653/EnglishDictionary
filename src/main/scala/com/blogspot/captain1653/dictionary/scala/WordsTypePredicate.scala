package com.blogspot.captain1653.dictionary.scala


object WordsTypePredicate {

  def apply(wordSearchCriteria: WordSearchCriteria): String => Boolean = {
    line => line.startsWith(wordSearchCriteria.partLine)
  }

}
