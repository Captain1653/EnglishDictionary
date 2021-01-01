package com.blogspot.captain1653;

import java.util.function.Predicate;

public class Configuration {

    private String questionStrategy;
    private String[] pathFiles;
    private String typeWord;
    private String folderForFiles;
    private String order;


    public String getQuestionStrategy() {
        return questionStrategy;
    }

    public void setQuestionStrategy(String questionStrategy) {
        this.questionStrategy = questionStrategy;
    }

    public void setPathFiles(String[] pathFiles) {
        this.pathFiles = pathFiles;
    }

    public String[] getPathFiles() {
        return pathFiles;
    }


    public void setTypeWord(String typeWord) {
        this.typeWord = typeWord;
    }

    public String getTypeWord() {
        return typeWord;
    }

    public void setFolderForFiles(String folderForFiles) {
        this.folderForFiles = folderForFiles;
    }

    public String getFolderForFiles() {
        return folderForFiles;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
