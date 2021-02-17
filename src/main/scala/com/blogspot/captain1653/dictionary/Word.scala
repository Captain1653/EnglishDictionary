package com.blogspot.captain1653.dictionary


class English(val text: String) extends AnyVal
class Russian(val text: String) extends AnyVal

case class Word(english: English,
                russian: Russian,
                wordType: WordType.Value,
                description: Option[String] = None)
