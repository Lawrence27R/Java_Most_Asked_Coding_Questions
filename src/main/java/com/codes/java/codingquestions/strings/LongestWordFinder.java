package com.codes.java.codingquestions.strings;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordFinder {

    // 1. Without Streams (Optimal Loop: O(n) Time, O(w) Space)
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        // Split by one or more spaces
        String[] words = sentence.split("\\s+");
        String longestWord = "";

        for (String word : words) {
            // Clean word from punctuation to get an accurate character length
            String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "");

            if (cleanedWord.length() > longestWord.length()) {
                longestWord = cleanedWord;
            }
        }
        return longestWord;
    }

    // 2. With Streams (Optimal Stream: O(n) Time, O(w) Space)
    public static String findLongestWordStream(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        return Arrays.stream(sentence.split("\\s+"))
                .map(word -> word.replaceAll("[^a-zA-Z0-9]", "")) // Clean punctuation
                .max(Comparator.comparingInt(String::length))     // Find maximum length
                .orElse("");
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Find Longest Word ---");
        String[] tests = {
                "The quick brown fox jumps over the lazy dog.", // "jumps"
                "Welcome to Java programming!",                 // "programming"
                "A magnificent, ultra-long sentence.",          // "magnificent"
                "   ",                                          // ""
                null                                            // ""
        };

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr +
                    " | Loop: \"" + findLongestWord(test) + "\"" +
                    " | Stream: \"" + findLongestWordStream(test) + "\"");
        }
    }
}