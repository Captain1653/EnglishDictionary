package com.blogspot.captain1653.dictionary.scala

import org.scalatest.funsuite.AnyFunSuite

class WordSuite extends AnyFunSuite {

  test("split on english and russian word by equal without description") {
    val word = new Word("home=дом")
    assert("home" == word.english)
    assert("дом" == word.russian)
    assert(null == word.description)
  }

  test("return description if it exists after russian word") {
    val word = new Word("home=дом=description")
    assert("home" == word.english)
    assert("дом" == word.russian)
    assert("description" == word.description)
  }
}
