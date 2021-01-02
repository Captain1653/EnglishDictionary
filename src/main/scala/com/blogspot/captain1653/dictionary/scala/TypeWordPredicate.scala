package com.blogspot.captain1653.dictionary.scala


object TypeWordPredicate {

  private def TYPES = List("noun", "adjective", "adverb", "verb")

  def apply(typeWord: String): String => Boolean = {
    typeWord match {
      case someType if TYPES.contains(someType) => someType => someType.startsWith(someType)
      case _ => _ => true
    }
  }

}
