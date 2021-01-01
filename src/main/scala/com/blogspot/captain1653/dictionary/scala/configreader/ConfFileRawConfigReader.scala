package com.blogspot.captain1653.dictionary.scala.configreader

import com.blogspot.captain1653.dictionary.scala.RawConfig
import com.typesafe.config.ConfigFactory

import java.io.File

class ConfFileRawConfigReader(pathToConfig: String) extends RawConfigReader {

  override def read(): RawConfig = {
    val config = ConfigFactory.parseFile(new File(pathToConfig)).getConfig("english.dictionary")
    RawConfig(
      folderForFiles = if (config.hasPath("folder")) config.getString("folder") else "",
      pathFiles = config.getString("files").split(","),
      questionStrategy = config.getString("mode"),
      typeWord = config.getString("type-word"),
      order = config.getString("order"))
  }
}
