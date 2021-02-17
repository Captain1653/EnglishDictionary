package com.blogspot.captain1653.dictionary.wordmapper

import com.blogspot.captain1653.dictionary.Word

trait StringWordMapper {

  def map(input: String): Word
}
