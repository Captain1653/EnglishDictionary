package com.blogspot.captain1653.configreader;

import com.blogspot.captain1653.dictionary.scala.DictionaryConfiguration;

import java.io.IOException;

public interface ConfigReader {

    DictionaryConfiguration readConfiguration() throws IOException;
}
