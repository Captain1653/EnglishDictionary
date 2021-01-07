package com.blogspot.captain1653.dictionary.wordsstream

import com.blogspot.captain1653.dictionary.{English, Russian, Word, WordsOrder}
import org.scalatest.funsuite.AnyFunSuite

class SequenceWordsStreamSuite extends AnyFunSuite {

  private val WORD_HOUSE = Word(new English("house"), new Russian("дом"))
  private val WORD_MOUSE = Word(new English("mouse"), new Russian("мышь"))

  test("get one word") {
    val wordsStream = WordsStreamFactory(List(WORD_HOUSE), WordsOrder.SEQUENTIAL)
    val firstActual = wordsStream.nextWord()
    assert("house" == firstActual.english.text)
    assert("дом" == firstActual.russian.text)
  }

  test("get two words") {
    val wordsStream = WordsStreamFactory(List(WORD_HOUSE, WORD_MOUSE), WordsOrder.SEQUENTIAL)
    val firstActual = wordsStream.nextWord()
    assert("house" == firstActual.english.text)
    assert("дом" == firstActual.russian.text)
    val secondActual = wordsStream.nextWord()
    assert("mouse" == secondActual.english.text)
    assert("мышь" == secondActual.russian.text)
  }

  test("start in loop after last word") {
    val wordsStream = WordsStreamFactory(List(WORD_HOUSE, WORD_MOUSE), WordsOrder.SEQUENTIAL)

    val firstActual = wordsStream.nextWord()
    assert("house" == firstActual.english.text)
    assert("дом" == firstActual.russian.text)

    val secondActual = wordsStream.nextWord()
    assert("mouse" == secondActual.english.text)
    assert("мышь" == secondActual.russian.text)

    val thirdActual = wordsStream.nextWord()
    assert("house" == thirdActual.english.text)
    assert("дом" == thirdActual.russian.text)
  }
}
