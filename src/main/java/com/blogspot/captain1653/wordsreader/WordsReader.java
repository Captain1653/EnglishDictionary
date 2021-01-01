package com.blogspot.captain1653.wordsreader;

import com.blogspot.captain1653.dictionary.scala.DictionaryConfig;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface WordsReader {

    List<String> getWords(DictionaryConfig configuration, Predicate<String> typeWordPredicate) throws IOException;
}
