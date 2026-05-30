package com.codes.java.codingquestions.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatingWordsFinder {

    // 1. Without Streams (Optimal Two-Set Approach: O(n) Time, O(w) Space)
    public static Set<String> findRepeatingWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return Collections.emptySet();
        }

        String[] words = sentence.toLowerCase().split("\\s+");
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new LinkedHashSet<>(); // Keeps insertion order of duplicates

        for (String word : words) {
            String cleaned = word.replaceAll("[^a-zA-Z0-9]", "");
            if (!cleaned.isEmpty()) {
                // If it fails to add to 'seen', it is a repeating word
                if (!seen.add(cleaned)) {
                    duplicates.add(cleaned);
                }
            }
        }
        return duplicates;
    }

    // 2. With Streams (Optimal Frequency Map: O(n) Time, O(w) Space)
    public static Set<String> findRepeatingWordsStream(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return Collections.emptySet();
        }

        return Arrays.stream(sentence.toLowerCase().split("\\s+"))
                .map(word -> word.replaceAll("[^a-zA-Z0-9]", ""))
                .filter(word -> !word.isEmpty())
                // Group words by their appearance count
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Filter out unique words
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Find Repeating Words ---");
        String[] tests = {
                "The track was wet, so the racecars spun out on the track.",
                "Hello world, hello Java!",
                "No duplicate words here",
                "",
                null
        };

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr +
                    " | Loop: " + findRepeatingWords(test) +
                    " | Stream: " + findRepeatingWordsStream(test));
        }
    }
}