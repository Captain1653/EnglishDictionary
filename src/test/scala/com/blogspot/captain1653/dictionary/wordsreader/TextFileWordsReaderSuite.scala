package com.blogspot.captain1653.dictionary.wordsreader

import com.blogspot.captain1653.dictionary.{English, Russian, Word}
import org.scalatest.funsuite.AnyFunSuite

class TextFileWordsReaderSuite extends AnyFunSuite {

  private val TEST_RESOURCES = "src/test/resources/"

  private val WORD_HOUSE = Word(new English("house"), new Russian("дом"))
  private val WORD_NEXT = Word(new English("next"), new Russian("следующий"))

  test("read all types words") {
    val typeWordPredicate = (_: String) => true
    val wordsReader: WordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "wordsreader/readAllWords.txt"))
    assert(List(WORD_HOUSE, WORD_NEXT) == wordsReader.getWords(typeWordPredicate))
  }

  test("read only nouns by predicate") {
    val typeWordPredicate = (line: String) => line.startsWith("noun")
    val wordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "wordsreader/readNouns.txt"))
    assert(List(WORD_HOUSE) == wordsReader.getWords(typeWordPredicate))
  }

  test("skip empty lines from file") {
    val typeWordPredicate = (_: String) => true
    val wordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "wordsreader/skipEmptyLinesFromFile.txt"))
    assert(List(WORD_HOUSE, WORD_NEXT) == wordsReader.getWords(typeWordPredicate))
  }
}
