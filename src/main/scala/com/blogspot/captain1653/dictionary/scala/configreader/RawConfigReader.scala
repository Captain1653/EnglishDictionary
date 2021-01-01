package com.blogspot.captain1653.dictionary.scala.configreader

import com.blogspot.captain1653.dictionary.scala.RawConfig

trait RawConfigReader {
  def read(): RawConfig
}
