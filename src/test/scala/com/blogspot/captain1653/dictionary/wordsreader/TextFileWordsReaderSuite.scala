package com.blogspot.captain1653.dictionary.wordsreader

import org.scalatest.funsuite.AnyFunSuite

class TextFileWordsReaderSuite extends AnyFunSuite {

  private val TEST_RESOURCES = "src/test/resources/"

  test("read all types words") {
    val typeWordPredicate = (line: String) => true
    val wordsReader: WordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "wordsreader/readAllWords.txt"))
    assert(List("house=дом", "next=следующий") == wordsReader.getWords(typeWordPredicate))
  }

  test("read only nouns by predicate") {
    val typeWordPredicate = (line: String) => line.startsWith("noun")
    val wordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "wordsreader/readNouns.txt"))
    assert(List("house=дом") == wordsReader.getWords(typeWordPredicate))
  }

  test("skip empty lines from file") {
    val typeWordPredicate = (line: String) => true
    val wordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "wordsreader/skipEmptyLinesFromFile.txt"))
    assert(List("house=дом", "next=следующий") == wordsReader.getWords(typeWordPredicate))
  }
}
