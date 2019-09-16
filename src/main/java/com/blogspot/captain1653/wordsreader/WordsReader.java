package com.blogspot.captain1653.wordsreader;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import com.blogspot.captain1653.Configuration;

public interface WordsReader {

    List<String> getWords(Configuration configuration, Predicate<String> typeWordPredicate) throws IOException;
}
