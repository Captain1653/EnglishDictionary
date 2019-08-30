package com.blogspot.captain1653;

import com.blogspot.captain1653.mode.QuestionStrategy;

public class Configuration {

    private QuestionStrategy questionStrategy;
    private String pathFile;

    public QuestionStrategy getQuestionStrategy() {
        return questionStrategy;
    }

    public void setQuestionStrategy(QuestionStrategy questionStrategy) {
        this.questionStrategy = questionStrategy;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getPathFile() {
        return pathFile;
    }
}
