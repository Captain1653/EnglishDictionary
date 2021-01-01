package com.blogspot.captain1653.dictionary.scala.configreader

import com.blogspot.captain1653.dictionary.scala.DictionaryConfig
import org.scalatest.funsuite.AnyFunSuite

class ConfFileConfigReaderSuite extends AnyFunSuite {

  test("read parameters from conf-file") {
    val pathToConfig = "src/test/resources/configreader/conf-file/fullConfiguration.conf"
    val dictionaryConfigReader = new ConfFileDictionaryConfigReader(pathToConfig)
    val conf: DictionaryConfig = dictionaryConfigReader.read()
    assert("someFolderForFiles" == conf.folderForFiles)
    assert("seq" == conf.order)
    assert("onePath" == conf.pathFiles(0))
    assert("twoPath" == conf.pathFiles(1))
    assert("ru" == conf.questionStrategy)
    assert("noun" == conf.typeWord)
  }

  test("return empty string if folderForFiles is not set") {
    val pathToConfig = "src/test/resources/configreader/conf-file/defaultValueFolderEmptyString.conf"
    val dictionaryConfigReader = new ConfFileDictionaryConfigReader(pathToConfig)
    val conf: DictionaryConfig = dictionaryConfigReader.read()
    assert("" == conf.folderForFiles)
  }

}
