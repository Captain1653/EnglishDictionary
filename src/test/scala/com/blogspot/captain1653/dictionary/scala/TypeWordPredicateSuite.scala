package com.blogspot.captain1653.dictionary.scala

import org.scalatest.funsuite.AnyFunSuite

class TypeWordPredicateSuite extends AnyFunSuite {

  test("return predicate for noun") {
    val predicate = TypeWordPredicate("noun")
    assert(predicate("noun"))
  }

  test("return predicate for adjective") {
    val predicate = TypeWordPredicate("adjective")
    assert(predicate("adjective"))
  }

  test("return predicate for verb") {
    val predicate = TypeWordPredicate("verb")
    assert(predicate("verb"))
  }

  test("return predicate for adverb") {
    val predicate = TypeWordPredicate("adverb")
    assert(predicate("adverb"))
  }
}
