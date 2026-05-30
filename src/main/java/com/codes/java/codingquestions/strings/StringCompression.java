package com.codes.java.codingquestions.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCompression {

    // 1. Standard Approach (Optimal Iteration: O(n) Time, O(n) Space)
    public static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If we are at the last character OR the next character is different
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);

                // Reset count for the next sequence of characters
                countConsecutive = 0;
            }
        }

        // Only return the compressed string if it actually saves space
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    // 2. Declarative Approach (Using Regex Matcher: O(n) Time, O(n) Space)
    public static String compressDeclarative(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();

        // Match any character "(.)" and then match that exact same character zero or more times "\\1*"
        Matcher matcher = Pattern.compile("(.)\\1*").matcher(str);

        while (matcher.find()) {
            // matcher.group(1) is the single character. matcher.group() is the whole repeated sequence.
            compressed.append(matcher.group(1));
            compressed.append(matcher.group().length());
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    // Test Cases
    public static void run() {
        System.out.println("--- String Compression ---");
        String[] tests = {
                "aabcccccaaa", // Expected: a2b1c5a3
                "abcd",        // Expected: abcd (a1b1c1d1 is longer)
                "nnn",         // Expected: n3
                "a",           // Expected: a
                "aabbcc",      // Expected: aabbcc (a2b2c2 is same length, return original)
                "",
                null
        };

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr);
            System.out.println("  Loop:  " + compress(test));
            System.out.println("  Regex: " + compressDeclarative(test));
            System.out.println();
        }
    }
}