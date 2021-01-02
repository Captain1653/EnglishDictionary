package com.blogspot.captain1653.dictionary.config.reader

import com.blogspot.captain1653.dictionary.config.RawConfig


trait RawConfigReader {
  def read(): RawConfig
}
