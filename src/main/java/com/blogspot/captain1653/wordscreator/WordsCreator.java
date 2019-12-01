package com.blogspot.captain1653.wordscreator;

import com.blogspot.captain1653.WordWithTranslation;

import java.util.List;

public interface WordsCreator {
    List<WordWithTranslation> create(List<String> lines);
}
