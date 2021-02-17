package com.blogspot.captain1653.dictionary.wordmapper
import com.blogspot.captain1653.dictionary.{English, Russian, Word, WordType}

class DefaultStringWordMapper extends StringWordMapper {

  private val delimiterTypeWord = ';'
  private val delimiterPartsWord = '='

  override def map(input: String): Word = input.split(Array(delimiterTypeWord, delimiterPartsWord)) match {
    case Array(english, russian) => Word(new English(english), new Russian(russian), WordType.ALL, None)
    case Array(wordType, english, russian) if input.contains(delimiterTypeWord) => Word(new English(english), new Russian(russian), resolveWordType(wordType), None)
    case Array(english, russian, description) => Word(new English(english), new Russian(russian), WordType.ALL, Some(description))
    case Array(wordType, english, russian, description) => Word(new English(english), new Russian(russian), resolveWordType(wordType), Some(description))
  }


  private def resolveWordType(wordType: String): WordType.Value = wordType match {
    case "noun" => WordType.NOUN
    case "verb" => WordType.VERB
    case "adjective" => WordType.ADJECTIVE
    case "adverb" => WordType.ADVERB
    case "all" => WordType.ALL
  }
}
