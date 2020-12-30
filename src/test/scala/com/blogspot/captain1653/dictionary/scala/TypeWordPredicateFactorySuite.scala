package com.blogspot.captain1653.dictionary.scala

import org.scalatest.funsuite.AnyFunSuite

import java.util.function.Predicate

class TypeWordPredicateFactorySuite extends AnyFunSuite {

  private val TYPE_WORD_PREDICATE_FACTORY = TypeWordPredicateFactory.createFactory()

  test("return predicate for noun") {
    val predicate: Predicate[String]  = TYPE_WORD_PREDICATE_FACTORY.create("noun")
    assert(predicate.test("noun"))
  }

  test("return predicate for adjective") {
    val predicate: Predicate[String] = TYPE_WORD_PREDICATE_FACTORY.create("adjective")
    assert(predicate.test("adjective"))
  }

  test("return predicate for verb") {
    val predicate: Predicate[String] = TYPE_WORD_PREDICATE_FACTORY.create("verb")
    assert(predicate.test("verb"))
  }

  test("return predicate for adverb") {
    val predicate: Predicate[String] = TYPE_WORD_PREDICATE_FACTORY.create("adverb")
    assert(predicate.test("adverb"))
  }
}
