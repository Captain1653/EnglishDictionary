package com.blogspot.captain1653.dictionary.scala.configreader

import com.blogspot.captain1653.dictionary.scala.DictionaryConfig

trait DictionaryConfigReader {
  def read(): DictionaryConfig
}
