package com.blogspot.captain1653.wordsreader;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface WordsReader {

    List<String> getWords(Predicate<String> typeWordPredicate) throws IOException;
}
