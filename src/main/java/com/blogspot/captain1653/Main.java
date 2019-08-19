package com.blogspot.captain1653;

import com.blogspot.captain1653.mode.EnglishQuestionStrategy;
import com.blogspot.captain1653.mode.MixQuestionStrategy;
import com.blogspot.captain1653.mode.QuestionMode;
import com.blogspot.captain1653.mode.QuestionStrategy;
import com.blogspot.captain1653.mode.RussianQuestionStrategy;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.blogspot.captain1653.ExternalProperty.MODE;
import static com.blogspot.captain1653.ExternalProperty.PATH_TO_FILE;
import static com.blogspot.captain1653.mode.QuestionMode.EN;

public class Main {

    private static final String EXIT_VALUE = "exit";

    public static void main(String[] args) throws IOException {
        String pathToFile = System.getProperty(PATH_TO_FILE.get());
        QuestionMode questionMode = QuestionMode.valueOf(System.getProperty(MODE.get(), EN.getMode()).toUpperCase());
        QuestionStrategy questionStrategy = getQuestionStrategy(questionMode);
        Map<Integer, WordWithTranslation> words = getWords(pathToFile);

        Scanner scanner = new Scanner(System.in);
        List<String> wordsWithMistakes = new ArrayList<>();

        int countQuestion = 0;
        while (true) {
            WordWithTranslation wordWithTranslation = words.get(new Random().nextInt(words.size()) + 1);
            String answerFromUser = questionStrategy.askQuestion(scanner, wordWithTranslation);
            String rightAnswer = questionStrategy.getRightAnswer(wordWithTranslation);

            if (EXIT_VALUE.equals(answerFromUser)) {
                System.out.println("Count question is: " + countQuestion);
                System.out.println("You have done " + wordsWithMistakes.size() + " mistakes");
                System.out.println("Words: are: " + String.join(",   ", wordsWithMistakes));
                return;
            }
            if (rightAnswer.equals(answerFromUser)) {
                System.out.println("TRUE");
            } else {
                System.out.println("NO!!!!!! Answer is '" + rightAnswer + "'");
                wordsWithMistakes.add(rightAnswer);
            }
            countQuestion++;
        }
    }

    private static QuestionStrategy getQuestionStrategy(QuestionMode questionMode) {
        QuestionStrategy rus = new RussianQuestionStrategy();
        QuestionStrategy en = new EnglishQuestionStrategy();
        QuestionStrategy mix = new MixQuestionStrategy();
        switch (questionMode) {
            case MIX: return mix;
            case RU: return rus;
            default: return en;
        }
    }

    private static Map<Integer, WordWithTranslation> getWords(String pathToFile) throws IOException {
        Scanner scanner = new Scanner(new File(pathToFile));
        Integer i = 1;
        Map<Integer, WordWithTranslation> words = new HashMap<>();
        while (scanner.hasNextLine()) {
            String lineWithWords = scanner.nextLine();
            WordWithTranslation wordWithTranslation = new WordWithTranslation(lineWithWords);
            words.put(i, wordWithTranslation);
            i++;
        }

        scanner.close();
        return words;
    }

}
