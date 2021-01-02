package com.blogspot.captain1653.dictionary.wordsstream

import com.blogspot.captain1653.dictionary.{Word, WordsOrder}

import scala.collection.mutable
import scala.util.Random

object WordsStreamFactory {

  def apply(list: List[Word], wordsOrder: WordsOrder.Value): WordsStream = wordsOrder match {
    case WordsOrder.SEQUENTIAL => new SequenceWordsStream(list)
    case WordsOrder.RANDOM => new RandomWordsStream(list)
  }

  private class SequenceWordsStream(list: List[Word]) extends WordsStream {

    private val words = mutable.Queue(list:_*)

    override def nextWord(): Word = {
      val word = words.dequeue()
      words.enqueue(word)
      word
    }
  }

  private class RandomWordsStream(list: List[Word]) extends WordsStream {

    private val wordsCount = list.size
    private val wordsByIndexes = list.zipWithIndex.map(_.swap).toMap

    override def nextWord(): Word = wordsByIndexes(new Random().nextInt(wordsCount))
  }
}

trait WordsStream {

  def nextWord(): Word
}