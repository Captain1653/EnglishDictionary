package com.blogspot.captain1653.wordsreader;

import java.io.IOException;
import java.util.Map;

import com.blogspot.captain1653.WordWithTranslation;

public interface WordsReader {

    Map<Integer, WordWithTranslation> getWords(String pathToFile) throws IOException;
}
