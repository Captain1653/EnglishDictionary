package com.blogspot.captain1653.dictionary.config.reader

import com.blogspot.captain1653.dictionary.config.RawConfig
import com.blogspot.captain1653.dictionary.config.reader.ConfFileRawConfigReader
import org.scalatest.funsuite.AnyFunSuite

class ConfFileConfigReaderSuite extends AnyFunSuite {

  test("read parameters from conf-file") {
    val pathToConfig = "src/test/resources/configreader/conf-file/fullConfiguration.conf"
    val rawConfigReader = new ConfFileRawConfigReader(pathToConfig)
    val conf: RawConfig = rawConfigReader.read()
    assert("someFolderForFiles" == conf.folderForFiles)
    assert("seq" == conf.order)
    assert("onePath,twoPath" == conf.pathFiles)
    assert("ru" == conf.questionStrategy)
    assert("noun" == conf.wordType)
  }

  test("return empty string if folderForFiles is not set") {
    val pathToConfig = "src/test/resources/configreader/conf-file/defaultValueFolderEmptyString.conf"
    val rawConfigReader = new ConfFileRawConfigReader(pathToConfig)
    val conf: RawConfig = rawConfigReader.read()
    assert("" == conf.folderForFiles)
  }

}
