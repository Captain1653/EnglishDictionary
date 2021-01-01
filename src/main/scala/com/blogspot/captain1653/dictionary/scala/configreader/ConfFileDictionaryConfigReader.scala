package com.blogspot.captain1653.dictionary.scala.configreader

import com.blogspot.captain1653.dictionary.scala.DictionaryConfig
import com.typesafe.config.ConfigFactory

import java.io.File

class ConfFileDictionaryConfigReader(pathToConfig: String) extends DictionaryConfigReader {

  override def read(): DictionaryConfig = {
    val config = ConfigFactory.parseFile(new File(pathToConfig)).getConfig("english.dictionary")
    DictionaryConfig(
      folderForFiles = if (config.hasPath("folder")) config.getString("folder") else "",
      pathFiles = config.getString("files").split(","),
      questionStrategy = config.getString("mode"),
      typeWord = config.getString("type-word"),
      order = config.getString("order"))
  }
}
