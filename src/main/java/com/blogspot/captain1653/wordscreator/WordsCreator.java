package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.dictionary.scala.Word;

import java.util.List;

public interface WordsCreator {
    List<Word> create(List<String> lines);
}
