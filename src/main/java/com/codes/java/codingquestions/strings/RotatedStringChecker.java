package com.codes.java.codingquestions.strings;

import java.util.stream.IntStream;

public class RotatedStringChecker {

    // 1. Without Streams (The Optimal Concatenation Trick: O(n) Time, O(n) Space)
    public static boolean isRotation(String s1, String s2) {
        // Step 1: Check for nulls and ensure lengths match
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Handle empty strings
        if (s1.isEmpty()) {
            return true;
        }

        // Step 3: The magic trick
        String concatenated = s1 + s1;

        // If s2 is a rotation, it MUST be a substring of s1 concatenated with itself
        return concatenated.contains(s2);
    }

    // 2. With Streams (Declarative Offset Matching: O(n^2) Time, O(1) Space)
    public static boolean isRotationStream(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        if (n == 0) return true;

        // Try every possible rotation offset 'i'
        return IntStream.range(0, n)
                .anyMatch(i ->
                        // Check if all characters match at this offset
                        IntStream.range(0, n)
                                .allMatch(j -> s1.charAt((i + j) % n) == s2.charAt(j))
                );
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Check Rotated Strings ---");

        String[][] tests = {
                {"waterbottle", "erbottlewat"}, // True
                {"hello", "llohe"},             // True
                {"java", "avaj"},               // False (This is reversed, not rotated)
                {"abc", "ab"},                  // False (Different lengths)
                {"", ""},                       // True
                {null, "test"}                  // False
        };

        for (String[] test : tests) {
            String s1 = (test[0] == null) ? "null" : "\"" + test[0] + "\"";
            String s2 = (test[1] == null) ? "null" : "\"" + test[1] + "\"";

            System.out.println("Input: s1=" + s1 + ", s2=" + s2);
            System.out.println("  Trick:  " + isRotation(test[0], test[1]));
            System.out.println("  Stream: " + isRotationStream(test[0], test[1]));
            System.out.println();
        }
    }
}