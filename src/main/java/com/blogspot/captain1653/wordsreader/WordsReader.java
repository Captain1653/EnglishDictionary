package com.blogspot.captain1653.wordsreader;

import com.blogspot.captain1653.dictionary.scala.RawConfig;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface WordsReader {

    List<String> getWords(RawConfig configuration, Predicate<String> typeWordPredicate) throws IOException;
}
