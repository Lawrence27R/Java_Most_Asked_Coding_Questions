package com.codes.java.codingquestions.strings;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {

    // 1. Without Streams (Optimal HashMap: O(n) Time, O(k) Space)
    public static Map<Character, Integer> count(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap(); // Safe, immutable empty map
        }

        // Using LinkedHashMap to maintain the insertion order of characters
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // getOrDefault handles the null check if the key doesn't exist yet
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }

    // 2. With Streams (Optimal Stream: O(n) Time, O(k) Space)
    public static Map<Character, Long> countStream(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }

        return str.chars()                  // 1. Create an IntStream of characters
                .mapToObj(c -> (char) c)        // 2. Box primitive ints into Character objects
                .collect(Collectors.groupingBy( // 3. Collect and group them
                        Function.identity(),        // The key is the character itself
                        LinkedHashMap::new,         // Force a LinkedHashMap to preserve order
                        Collectors.counting()       // The value is the count of occurrences
                ));
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Character Frequency ---");
        String[] tests = {
                "hello",
                "programming",
                "Lawrence",
                "",
                null
        };

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr);
            System.out.println("  Loop:   " + count(test));
            System.out.println("  Stream: " + countStream(test));
            System.out.println();
        }
    }
}