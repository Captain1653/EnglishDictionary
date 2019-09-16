package com.blogspot.captain1653.wordsreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.blogspot.captain1653.Configuration;

public class TextFileWordsReader implements WordsReader {

    @Override
    public List<String> getWords(Configuration configuration, Predicate<String> typeWordPredicate) throws IOException {
        List<String> lines = new ArrayList<>();
        String folderForFiles = configuration.getFolderForFiles();
        for (String path : configuration.getPathFiles()) {
            String fullPathToFile = folderForFiles + path;
            Scanner scanner = new Scanner(new File(fullPathToFile));
            while (scanner.hasNextLine()) {
                String lineWithWords = scanner.nextLine();
                if (typeWordPredicate.test(lineWithWords)) {
                    lines.add(lineWithWords);
                }
            }
            scanner.close();
        }
        return lines;
    }
}
