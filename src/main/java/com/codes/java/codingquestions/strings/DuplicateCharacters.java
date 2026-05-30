package com.codes.java.codingquestions.strings;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    // 1. Without Streams (Optimal Two-Set Approach: O(n) Time, O(k) Space)
    public static Set<Character> findDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptySet();
        }

        Set<Character> seen = new HashSet<>();
        // LinkedHashSet keeps the order in which duplicates are discovered
        Set<Character> duplicates = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // If the character cannot be added to 'seen', it means it's a duplicate
            if (!seen.add(c)) {
                duplicates.add(c);
            }
        }
        return duplicates;
    }

    // 2. With Streams (Optimal Grouping Approach: O(n) Time, O(k) Space)
    public static Set<Character> findDuplicatesStream(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptySet();
        }

        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Filter out unique characters
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Find Duplicate Characters ---");
        String[] tests = {"programming", "Java", "abcdef", "", null};

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr +
                    " | Loop: " + findDuplicates(test) +
                    " | Stream: " + findDuplicatesStream(test));
        }
    }
}