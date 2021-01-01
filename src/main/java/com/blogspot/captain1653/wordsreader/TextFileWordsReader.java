package com.blogspot.captain1653.wordsreader;

import com.blogspot.captain1653.dictionary.scala.RawConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TextFileWordsReader implements WordsReader {

    private static final String EMPTY_LINE = "";
    private static final String DELIMITER_TYPE_WORD = ";";

    @Override
    public List<String> getWords(RawConfig configuration, Predicate<String> typeWordPredicate) throws IOException {
        List<String> lines = new ArrayList<>();
        String folderForFiles = configuration.folderForFiles();

        String[] pathFiles = "*".equals(configuration.pathFiles()[0]) ?
                             getAllFilesInFolder(folderForFiles) :
                             configuration.pathFiles();

        for (String path : pathFiles) {
            String fullPathToFile = folderForFiles + path;
            try (Scanner scanner = new Scanner(new File(fullPathToFile))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (isAppropriateLine(typeWordPredicate, line)) {
                        lines.add(line.contains(DELIMITER_TYPE_WORD) ? line.split(DELIMITER_TYPE_WORD)[1] : line);
                    }
                }
            }
        }
        return lines;
    }

    private String[] getAllFilesInFolder(String folderForFiles) {
        return Stream.of(new File(folderForFiles).listFiles())
                .map(File::getName)
                .toArray(String[]::new);
    }

    private boolean isAppropriateLine(Predicate<String> typeWordPredicate, String lineWithWords) {
        return !EMPTY_LINE.equals(lineWithWords) && typeWordPredicate.test(lineWithWords);
    }
}
