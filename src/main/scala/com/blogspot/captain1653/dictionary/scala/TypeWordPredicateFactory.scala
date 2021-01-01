package com.blogspot.captain1653.dictionary.scala

import java.util.function.Predicate

object TypeWordPredicateFactory {
  private def TYPES = List("noun", "adjective", "adverb", "verb")

  def apply(): TypeWordPredicateFactory = new TypeWordPredicateFactory(TYPES)

}

class TypeWordPredicateFactory private (private val types: List[String]) {

  def create(typeWord: String): Predicate[String] = {
    typeWord match {
      case someType if types.contains(someType) => new Predicate[String] {
        override def test(line: String): Boolean = line.startsWith(someType)
      }
      case _ => new Predicate[String] {
        override def test(t: String): Boolean = true
      }
    }
  }

}
