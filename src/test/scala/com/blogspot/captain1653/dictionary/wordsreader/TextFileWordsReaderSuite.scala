package com.blogspot.captain1653.dictionary.wordsreader

import com.blogspot.captain1653.dictionary.wordmapper.StringWordMapper
import com.blogspot.captain1653.dictionary.{English, Russian, Word, WordType}
import org.scalatest.funsuite.AnyFunSuite

class TextFileWordsReaderSuite extends AnyFunSuite {

  private val TEST_RESOURCES = "src/test/resources/wordsreader/"

  private val WORD_HOUSE = Word(new English("house"), new Russian("дом"), WordType.NOUN)
  private val WORD_NEXT = Word(new English("next"), new Russian("следующий"), WordType.ADJECTIVE)

  test("read all types words") {
    val allWordsPredicate = (_: Word) => true
    val mapper = new StringWordMapper {
      override def map(input: String): Word = if (input.contains("noun"))  WORD_HOUSE else WORD_NEXT
    }
    val wordsReader: WordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "readAllWords.txt"), mapper)
    assert(List(WORD_HOUSE, WORD_NEXT) == wordsReader.getWords(allWordsPredicate))
  }

  test("read only nouns by predicate") {
    val nounWordPredicate = (word: Word) => word.wordType == WordType.NOUN
    val mapper = new StringWordMapper {
      override def map(input: String): Word = if (input.contains("noun"))  WORD_HOUSE else WORD_NEXT
    }
    val wordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "readNouns.txt"), mapper)
    assert(List(WORD_HOUSE) == wordsReader.getWords(nounWordPredicate))
  }

  test("skip empty lines from file") {
    val allWordsPredicate = (_: Word) => true
    val mapper = new StringWordMapper {
      override def map(input: String): Word = if (input.contains("noun")) WORD_HOUSE else WORD_NEXT
    }
    val wordsReader = new TextFileWordsReader(Array[String](TEST_RESOURCES + "skipEmptyLinesFromFile.txt"), mapper)
    assert(List(WORD_HOUSE, WORD_NEXT) == wordsReader.getWords(allWordsPredicate))
  }
}
