package com.blogspot.captain1653.dictionary.scala.wordsstream

import com.blogspot.captain1653.dictionary.scala.Word

import scala.collection.mutable
import scala.util.Random
import scala.collection.JavaConverters.asScalaBufferConverter

object WordsStreamFactory {

  def apply(list: java.util.List[Word], wordsStreamType: String): WordsStream = {
    if ("seq" == wordsStreamType) new SequenceWordsStream(list.asScala.toList) else new RandomWordsStream(list.asScala.toList)
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