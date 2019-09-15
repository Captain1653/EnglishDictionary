package com.blogspot.captain1653.wordsreader;

import java.io.IOException;
import java.util.Map;
import java.util.function.Predicate;

import com.blogspot.captain1653.Configuration;
import com.blogspot.captain1653.WordWithTranslation;

public interface WordsReader {

    Map<Integer, WordWithTranslation> getWords(Configuration configuration, Predicate<String> typeWordPredicate) throws IOException;
}
