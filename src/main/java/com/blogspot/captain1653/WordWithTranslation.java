package com.blogspot.captain1653;

import java.util.Objects;

public class WordWithTranslation {

    private String english;
    private String russian;
    private String description;

    public WordWithTranslation(String lineWithWords) {
        String[] englishAndRussian = lineWithWords.split("=");
        this.english = englishAndRussian[0];
        this.russian = englishAndRussian[1];
        if (englishAndRussian.length > 2) {
            this.description = englishAndRussian[2];
        }
    }

    public String getEnglish() {
        return english;
    }

    public String getRussian() {
        return russian;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWithTranslation that = (WordWithTranslation) o;
        return Objects.equals(english, that.english) &&
                Objects.equals(russian, that.russian) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(english, russian, description);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("English=").append(english).append(", ")
                .append("Russian=").append(russian).append(", ")
                .append("Description=").append(description).append(".");
        return stringBuilder.toString();
    }
}
