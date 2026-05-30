package com.codes.java.codingquestions.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    // 1. Without Streams (Optimal Array: O(n) Time, O(1) Space)
    public static Character findFirst(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        // Assuming standard ASCII characters.
        int[] charCounts = new int[256];

        // First pass: Count the frequency of each character
        for (int i = 0; i < str.length(); i++) {
            charCounts[str.charAt(i)]++;
        }

        // Second pass: Find the first character with a frequency of exactly 1
        for (int i = 0; i < str.length(); i++) {
            if (charCounts[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return null; // Return null if all characters repeat
    }

    // 2. With Streams (LinkedHashMap: O(n) Time, O(n) Space)
    public static Character findFirstStream(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        return str.chars()                 // Create an IntStream of characters
                .mapToObj(c -> (char) c)       // Box primitive ints to Character objects
                .collect(Collectors.groupingBy(
                        Function.identity(),       // The character itself is the key
                        LinkedHashMap::new,        // CRITICAL: LinkedHashMap preserves insertion order
                        Collectors.counting()      // Count occurrences
                ))
                .entrySet().stream()           // Stream the map entries
                .filter(e -> e.getValue() == 1L) // Filter out repeating characters
                .map(Map.Entry::getKey)        // Extract the character
                .findFirst()                   // Get the first one that matches
                .orElse(null);
    }

    // Test Cases
    public static void run() {
        System.out.println("--- First Non-Repeating Character ---");
        String[] tests = {
                "swiss",       // 'w'
                "programming", // 'p'
                "aabbcc",      // null
                "Lawrence",    // 'L'
                null,
                ""
        };

        for (String test : tests) {
            System.out.println("Input: " + (test == null ? "null" : "\"" + test + "\"") +
                    " | Array: " + findFirst(test) +
                    " | Stream: " + findFirstStream(test));
        }
    }
}