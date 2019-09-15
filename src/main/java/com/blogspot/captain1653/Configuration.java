package com.blogspot.captain1653;

import com.blogspot.captain1653.mode.QuestionStrategy;

import java.util.function.Predicate;

public class Configuration {

    private QuestionStrategy questionStrategy;
    private String[] pathFiles;
    private Predicate<String> typeWordPredicate;
    private String folderForFiles;


    public QuestionStrategy getQuestionStrategy() {
        return questionStrategy;
    }

    public void setQuestionStrategy(QuestionStrategy questionStrategy) {
        this.questionStrategy = questionStrategy;
    }

    public void setPathFiles(String[] pathFiles) {
        this.pathFiles = pathFiles;
    }

    public String[] getPathFiles() {
        return pathFiles;
    }


    public void setTypeWordPredicate(Predicate<String> typeWordPredicate) {
        this.typeWordPredicate = typeWordPredicate;
    }

    public Predicate<String> getTypeWordPredicate() {
        return typeWordPredicate;
    }

    public void setFolderForFiles(String folderForFiles) {
        this.folderForFiles = folderForFiles;
    }

    public String getFolderForFiles() {
        return folderForFiles;
    }
}
