package com.blogspot.captain1653.wordsreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class TextFileWordsReader implements WordsReader {

    private static final String EMPTY_LINE = "";
    private static final String DELIMITER_TYPE_WORD = ";";

    private String[] pathFiles;

    public TextFileWordsReader(String[] pathFiles) {
        this.pathFiles = pathFiles;
    }

    @Override
    public List<String> getWords(Predicate<String> typeWordPredicate) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String path : pathFiles) {
            try (Scanner scanner = new Scanner(new File(path))) {
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

    private boolean isAppropriateLine(Predicate<String> typeWordPredicate, String lineWithWords) {
        return !EMPTY_LINE.equals(lineWithWords) && typeWordPredicate.test(lineWithWords);
    }
}
