package com.codes.java.codingquestions.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SentenceWordReverser {

    // 1. Without Streams (Optimal Reverse Append: O(n) Time, O(n) Space)
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return sentence;
        }

        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        // Iterate backwards through the array of words
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" "); // Add space separator between words
            }
        }
        return sb.toString();
    }

    // 2. With Streams (Optimal Inverse IntStream Mapping: O(n) Time, O(n) Space)
    public static String reverseWordsStream(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return sentence;
        }

        String[] words = sentence.trim().split("\\s+");

        // Map indices backwards to pull words in reverse order
        return IntStream.range(0, words.length)
                .mapToObj(i -> words[words.length - 1 - i])
                .collect(Collectors.joining(" "));
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Reverse Words in Sentence ---");
        String[] tests = {
                "Java coding question",
                "  Fly me   to the moon  ",
                "SingleWord",
                "",
                null
        };

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr);
            System.out.println("  Loop:   \"" + reverseWords(test) + "\"");
            System.out.println("  Stream: \"" + reverseWordsStream(test) + "\"");
        }
    }
}