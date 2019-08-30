package com.blogspot.captain1653;

import java.util.function.Predicate;

public class TypeWordPredicateFactory {

    public Predicate<String> create(String typeWord) {
        switch (typeWord) {
            case "noun": return line -> line.startsWith("noun");
            case "adjective": return line -> line.startsWith("adjective");
            case "adverb": return line -> line.startsWith("adverb");
            case "verb": return line -> line.startsWith("verb");
            default: return line -> true;
        }
    }

}
