package com.codes.java.codingquestions.strings;

import java.util.Arrays;

public class AnagramChecker {

    // 1. Without Streams (Optimal Frequency Array: O(n) Time, O(1) Space)
    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        // Assuming ASCII characters. Use HashMap if Unicode is required.
        int[] charCounts = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            charCounts[s1.charAt(i)]++;
            charCounts[s2.charAt(i)]--;
        }

        // If it's an anagram, all counts will have balanced back to 0
        for (int count : charCounts) {
            if (count != 0) return false;
        }
        return true;
    }

    // 2. With Streams (Sorting approach: O(n log n) Time, O(n) Space)
    public static boolean isAnagramStream(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        // Sorting is the most idiomatic stream way, though slightly slower than frequency array
        int[] sorted1 = s1.chars().sorted().toArray();
        int[] sorted2 = s2.chars().sorted().toArray();

        return Arrays.equals(sorted1, sorted2);
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Anagram Checker ---");
        String[][] tests = {
                {"listen", "silent"},
                {"hello", "world"},
                {"a", "a"},
                {"triangle", "integral"},
                {null, "test"}
        };

        for (String[] test : tests) {
            System.out.println("Input: [" + test[0] + ", " + test[1] + "]" +
                    " | Array: " + isAnagram(test[0], test[1]) +
                    " | Stream: " + isAnagramStream(test[0], test[1]));
        }
    }
}