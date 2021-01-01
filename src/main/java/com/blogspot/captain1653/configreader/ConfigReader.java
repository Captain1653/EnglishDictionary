package com.blogspot.captain1653.configreader;

import java.io.IOException;

import com.blogspot.captain1653.Configuration;

public interface ConfigReader {

    Configuration readConfiguration() throws IOException;
}
