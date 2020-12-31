package com.blogspot.captain1653.dictionary.scala

class Word(line: String) {

  val (english, russian, description) = line.split("=") match {
    case Array(one, two, three) => (one, two, three)
    case Array(one, two) => (one, two, null)
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Word]

  override def equals(other: Any): Boolean = other match {
    case that: Word =>
      (that canEqual this) &&
        english == that.english &&
        russian == that.russian &&
        description == that.description
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(english, russian, description)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
