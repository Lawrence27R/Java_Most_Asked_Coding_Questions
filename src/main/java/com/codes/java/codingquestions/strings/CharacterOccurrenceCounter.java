package com.codes.java.codingquestions.strings;

public class CharacterOccurrenceCounter {

    // 1. Without Streams (Optimal Loop: O(n) Time, O(1) Space)
    public static int countOccurrence(String str, char target) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }

        return count;
    }

    // 2. With Streams (Optimal Stream: O(n) Time, O(1) Space)
    public static long countOccurrenceStream(String str, char target) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        return str.chars()                       // 1. Create an IntStream of characters
                .filter(c -> c == target)      // 2. Filter only for the target character
                .count();                      // 3. Count the remaining elements
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Count Occurrence of Specific Character ---");

        String testString = "programming in java";
        char[] targets = {'r', 'g', 'a', 'z'};

        System.out.println("Input String: \"" + testString + "\"");

        for (char target : targets) {
            System.out.println("Target: '" + target + "'" +
                    " | Loop: " + countOccurrence(testString, target) +
                    " | Stream: " + countOccurrenceStream(testString, target));
        }

        // Edge Cases
        System.out.println("Target: 'a' | Loop (null): " + countOccurrence(null, 'a') +
                " | Stream (null): " + countOccurrenceStream(null, 'a'));
    }
}