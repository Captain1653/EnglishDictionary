package com.blogspot.captain1653;

import com.blogspot.captain1653.configreader.ConfigReader;
import com.blogspot.captain1653.configreader.PropertyConfigReader;
import com.blogspot.captain1653.dictionary.scala.TypeWordPredicateFactory;
import com.blogspot.captain1653.dictionary.scala.Word;
import com.blogspot.captain1653.dictionary.scala.wordsstream.WordsStream;
import com.blogspot.captain1653.dictionary.scala.wordsstream.WordsStreamFactory;
import com.blogspot.captain1653.mode.QuestionStrategy;
import com.blogspot.captain1653.mode.QuestionStrategyFactory;
import com.blogspot.captain1653.wordscreator.SimpleWordsCreator;
import com.blogspot.captain1653.wordscreator.WordsCreator;
import com.blogspot.captain1653.wordsreader.TextFileWordsReader;
import com.blogspot.captain1653.wordsreader.WordsReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

import static com.blogspot.captain1653.ExternalProperty.PATH_TO_CONFIG;

public class Main {

    private static final String EXIT_VALUE = "exit";

    public static void main(String[] args) throws IOException {
        QuestionStrategyFactory questionStrategyFactory = new QuestionStrategyFactory();
        ConfigReader configReader = new PropertyConfigReader(questionStrategyFactory, TypeWordPredicateFactory.createFactory());
        Configuration configuration = configReader.readConfiguration(System.getProperty(PATH_TO_CONFIG,"/home/andrey/Others/english/config.properties"));
        QuestionStrategy questionStrategy = configuration.getQuestionStrategy();

        Predicate<String> typeWordPredicate = configuration.getTypeWordPredicate();
        WordsReader wordsReader = new TextFileWordsReader();
        List<String> lines = wordsReader.getWords(configuration, typeWordPredicate);
        WordsCreator wordsCreator = new SimpleWordsCreator();
        List<Word> words = wordsCreator.create(lines);

        WordsStream wordsStream = WordsStreamFactory.apply(words, configuration.getOrder());

        Scanner scanner = new Scanner(System.in);
        Set<String> wordsWithMistakes = new HashSet<>();

        int countQuestion = 0;
        while (true) {
            Word word = wordsStream.nextWord();
            String answerFromUser = questionStrategy.askQuestion(scanner, word);
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
