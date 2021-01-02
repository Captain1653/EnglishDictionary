package com.blogspot.captain1653.dictionary.config.reader

import com.blogspot.captain1653.dictionary.config.RawConfig
import com.typesafe.config.ConfigFactory

import java.io.File

class ConfFileRawConfigReader(pathToConfig: String) extends RawConfigReader {

  private val WORD_TYPE = "type-word"
  private val FOLDER = "folder"
  private val ORDER = "order"
  private val FILES = "files"
  private val MODE = "mode"

  override def read(): RawConfig = {
    val config = ConfigFactory.parseFile(new File(pathToConfig)).getConfig("english.dictionary")
    RawConfig(
      folderForFiles = if (config.hasPath(FOLDER)) config.getString(FOLDER) else "",
      pathFiles = config.getString(FILES).split(","),
      questionStrategy = config.getString(MODE),
      wordType = config.getString(WORD_TYPE),
      order = config.getString(ORDER))
  }
}
