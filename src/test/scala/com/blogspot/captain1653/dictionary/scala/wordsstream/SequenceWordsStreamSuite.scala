package com.blogspot.captain1653.dictionary.scala.wordsstream

import com.blogspot.captain1653.dictionary.scala.Word
import org.scalatest.funsuite.AnyFunSuite

import java.util
import java.util.Collections

class SequenceWordsStreamSuite extends AnyFunSuite{

  test("get one word"){
    val wordsStream = WordsStreamFactory.apply(Collections.singletonList(new Word("house=дом")),"seq")
    val firstActual = wordsStream.nextWord()
    assert("house" == firstActual.english)
    assert("дом" == firstActual.russian)
  }

  test("get two words") {
    val firstWord = new Word("house=дом")
    val secondWord = new Word("mouse=мышь")
    val wordsStream = WordsStreamFactory.apply(util.Arrays.asList(firstWord, secondWord),"seq")
    val firstActual = wordsStream.nextWord()
    assert("house" == firstActual.english)
    assert("дом" == firstActual.russian)
    val secondActual = wordsStream.nextWord()
    assert("mouse" == secondActual.english)
    assert("мышь" == secondActual.russian)
  }

  test("start in loop after last word") {
    val firstWord = new Word("house=дом")
    val secondWord = new Word("mouse=мышь")
    val wordsStream = WordsStreamFactory.apply(util.Arrays.asList(firstWord, secondWord),"seq")

    val firstActual = wordsStream.nextWord()
    assert("house" == firstActual.english)
    assert("дом" == firstActual.russian)

    val secondActual = wordsStream.nextWord()
    assert("mouse" == secondActual.english)
    assert("мышь" == secondActual.russian)

    val thirdActual = wordsStream.nextWord()
    assert("house" == thirdActual.english)
    assert("дом" == thirdActual.russian)
  }
}
