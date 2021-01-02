package com.blogspot.captain1653.dictionary.scala

import java.io.File

class FilePathResolver(dictionaryConfig: DictionaryConfig) {
  def absoluteFilePaths: Array[String] = {
    if ("*" == dictionaryConfig.files(0)) {
      getAllFilesInFolder(dictionaryConfig.folder)
    } else {
      dictionaryConfig.files
    }
  }

  private def getAllFilesInFolder(folderForFiles: String): Array[String] = {
    new File(folderForFiles).listFiles.map(folderForFiles + _.getName)
  }

}
