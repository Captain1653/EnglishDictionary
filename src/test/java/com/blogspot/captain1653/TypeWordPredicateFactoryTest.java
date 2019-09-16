package com.blogspot.captain1653;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TypeWordPredicateFactoryTest {

    private TypeWordPredicateFactory typeWordPredicateFactory = new TypeWordPredicateFactory();

    @Test
    void returnPredicateForNoun() {
        Predicate<String> predicate = typeWordPredicateFactory.create("noun");
        assertTrue(predicate.test("noun"));
    }

    @Test
    void returnPredicateForAdjective() {
        Predicate<String> predicate = typeWordPredicateFactory.create("adjective");
        assertTrue(predicate.test("adjective"));
    }

    @Test
    void returnPredicateForVerb() {
        Predicate<String> predicate = typeWordPredicateFactory.create("verb");
        assertTrue(predicate.test("verb"));
    }

    @Test
    void returnPredicateForAdverb() {
        Predicate<String> predicate = typeWordPredicateFactory.create("adverb");
        assertTrue(predicate.test("adverb"));
    }
}
