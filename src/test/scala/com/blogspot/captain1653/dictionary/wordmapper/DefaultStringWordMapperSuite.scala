package com.blogspot.captain1653.dictionary.wordmapper

import com.blogspot.captain1653.dictionary.WordType
import org.scalatest.funsuite.AnyFunSuite

class DefaultStringWordMapperSuite extends AnyFunSuite{

  private val mapper: StringWordMapper = new DefaultStringWordMapper()

  test("make word pattern: englishWord=russianWord") {
    val word = mapper.map("house=дом")
    assert(word.english.text == "house")
    assert(word.russian.text == "дом")
    assert(word.wordType == WordType.ALL)
  }

  test("make word pattern: noun;englishWord=russianWord") {
    val word = mapper.map("noun;house=дом")
    assert(word.english.text == "house")
    assert(word.russian.text == "дом")
    assert(word.wordType == WordType.NOUN)
  }

  test("make word pattern: verb;englishWord=russianWord") {
    val word = mapper.map("verb;do=делать")
    assert(word.english.text == "do")
    assert(word.russian.text == "делать")
    assert(word.wordType == WordType.VERB)
  }

  test("make word pattern: adjective;englishWord=russianWord") {
    val word = mapper.map("adjective;red=красный")
    assert(word.english.text == "red")
    assert(word.russian.text == "красный")
    assert(word.wordType == WordType.ADJECTIVE)
  }

  test("make word pattern: adverb;accidentally=случайно") {
    val word = mapper.map("adverb;accidentally=случайно")
    assert(word.english.text == "accidentally")
    assert(word.russian.text == "случайно")
    assert(word.wordType == WordType.ADVERB)
  }

  test("make word pattern: all;englishWord=russianWord") {
    val word = mapper.map("all;do=делать")
    assert(word.english.text == "do")
    assert(word.russian.text == "делать")
    assert(word.wordType == WordType.ALL)
  }

  test("make word pattern: englishWord=russianWord=description") {
    val word = mapper.map("do=делать=important")
    assert(word.english.text == "do")
    assert(word.russian.text == "делать")
    assert(word.description.getOrElse("") == "important")
    assert(word.wordType == WordType.ALL)
  }

  test("make word pattern: noun;englishWord=russianWord=description") {
    val word = mapper.map("verb;do=делать=important")
    assert(word.english.text == "do")
    assert(word.russian.text == "делать")
    assert(word.description.getOrElse("") == "important")
    assert(word.wordType == WordType.VERB)
  }
}
