package com.codes.java.codingquestions.strings;

public class RemoveDuplicateCharacters {

    // 1. Without Streams (Optimal Array Tracker: O(n) Time, O(1) Space)
    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Assuming ASCII characters. Use a Set<Character> if Unicode is required.
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen[c]) {
                seen[c] = true;   // Mark as seen
                sb.append(c);     // Append to our unique result sequence
            }
        }
        return sb.toString();
    }

    // 2. With Streams (Highly Optimized Primitive Stream: O(n) Time, O(k) Space)
    public static String removeDuplicatesStream(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.chars()          // Returns an IntStream of code points (primitive values)
                .distinct()         // Standard intermediate stream method to eliminate duplicates
                // Collect directly into a StringBuilder using primitive appendCodePoint to avoid boxing
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Remove Duplicate Characters ---");
        String[] tests = {"programming", "bananas", "aabbcc", "", null};

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr);
            System.out.println("  Loop:   \"" + removeDuplicates(test) + "\"");
            System.out.println("  Stream: \"" + removeDuplicatesStream(test) + "\"");
        }
    }
}