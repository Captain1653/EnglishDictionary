package com.blogspot.captain1653;

import com.blogspot.captain1653.dictionary.scala.*;
import com.blogspot.captain1653.dictionary.scala.configreader.ConfFileRawConfigReader;
import com.blogspot.captain1653.dictionary.scala.configreader.RawConfigReader;
import com.blogspot.captain1653.dictionary.scala.questionstrategy.QuestionStrategy;
import com.blogspot.captain1653.dictionary.scala.questionstrategy.QuestionStrategyFactory;
import com.blogspot.captain1653.dictionary.scala.wordsstream.WordsStream;
import com.blogspot.captain1653.dictionary.scala.wordsstream.WordsStreamFactory;
import com.blogspot.captain1653.wordsreader.TextFileWordsReader;
import com.blogspot.captain1653.wordsreader.WordsReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    private static final String EXIT_VALUE = "exit";

    public static void main(String[] args) throws IOException {
        RawConfigReader configReader = new ConfFileRawConfigReader(args[0]);
        RawConfig rawConfig = configReader.read();
        RawConfigParser rawConfigParser = new RawConfigParser(rawConfig);
        DictionaryConfig dictionaryConfig = rawConfigParser.parse();
        QuestionStrategy questionStrategy = QuestionStrategyFactory.apply(dictionaryConfig.questionStrategyType());

        Predicate<String> typeWordPredicate = TypeWordPredicateFactory.apply().create(rawConfig.typeWord());
        FilePathResolver filePathResolver = new FilePathResolver(dictionaryConfig);
        WordsReader wordsReader = new TextFileWordsReader(filePathResolver.absoluteFilePaths());
        List<String> lines = wordsReader.getWords(typeWordPredicate);
        List<Word> words = lines.stream().map(Word::new).collect(Collectors.toList());

        WordsStream wordsStream = WordsStreamFactory.apply(words, dictionaryConfig.order());

        Scanner scanner = new Scanner(System.in);
        Set<String> wordsWithMistakes = new HashSet<>();

        int countQuestion = 0;
        while (true) {
            Word word = wordsStream.nextWord();
            String question = questionStrategy.askQuestion(word);
            System.out.println("Word: " + question);
            String answerFromUser = scanner.nextLine();
            String rightAnswer = questionStrategy.getRightAnswer(word);

            if (EXIT_VALUE.equals(answerFromUser)) {
                System.out.printf("Count question is: %d%n", countQuestion);
                int countMistakes = wordsWithMistakes.size();
                System.out.printf("You have done %d mistakes%n", countMistakes);
                if (countMistakes > 0) {
                    System.out.println("Words: are: " + String.join(",   ", wordsWithMistakes));
                }
                return;
            }
            if (rightAnswer.equalsIgnoreCase(answerFromUser)) {
                System.out.println("TRUE");
            } else {
                System.out.println("NO!!!!!! Answer is '" + rightAnswer + "'");
                wordsWithMistakes.add(rightAnswer);
            }
            countQuestion++;
        }
    }

}
