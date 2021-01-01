package com.blogspot.captain1653;

import java.util.function.Predicate;

public class Configuration {

    private String questionStrategy;
    private String[] pathFiles;
    private Predicate<String> typeWordPredicate;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
