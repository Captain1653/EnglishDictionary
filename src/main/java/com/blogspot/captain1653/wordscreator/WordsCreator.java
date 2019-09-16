package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.List;
import java.util.Map;

public interface WordsCreator {
    Map<Integer, WordWithTranslation> create(List<String> lines);
}
