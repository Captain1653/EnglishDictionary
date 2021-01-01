package com.blogspot.captain1653.dictionary.scala

import org.scalatest.funsuite.AnyFunSuite

class RawConfigParserSuite extends AnyFunSuite {

  test("parse WordsOrder from String") {
    val rawConfig = RawConfig("", Array(), "", "", order = "seq")
    val parser = new RawConfigParser(rawConfig)
    val dictionaryConfig = parser.parse();
    assert(WordsOrder.SEQUENTIAL == dictionaryConfig.order)
  }
}
