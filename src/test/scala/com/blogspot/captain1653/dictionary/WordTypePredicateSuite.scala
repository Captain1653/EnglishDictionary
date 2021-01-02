package com.blogspot.captain1653.dictionary

import org.scalatest.funsuite.AnyFunSuite

class WordTypePredicateSuite extends AnyFunSuite {

  test("return predicate for noun") {
    val predicate = WordsTypePredicate(WordSearchCriteria("noun", WordType.NOUN))
    assert(predicate("noun"))
  }

  test("return predicate for adjective") {
    val predicate = WordsTypePredicate(WordSearchCriteria("adjective", WordType.ADJECTIVE))
    assert(predicate("adjective"))
  }

  test("return predicate for verb") {
    val predicate = WordsTypePredicate(WordSearchCriteria("verb", WordType.VERB))
    assert(predicate("verb"))
  }

  test("return predicate for adverb") {
    val predicate = WordsTypePredicate(WordSearchCriteria("adverb",WordType.ADVERB))
    assert(predicate("adverb"))
  }
}
