package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

    // 1. Optimal Approach for Strings (ASCII Frequency Array)
    // Time: O(N), Space: O(1) - The array size is fixed at 256 regardless of input size
    public static char firstNonRepeatingChar(String s) {
        if (s == null || s.isEmpty()) {
            return '_'; // Return a default placeholder for empty/null strings
        }

        // Assuming standard ASCII characters.
        // (Use 26 if the interviewer specifies lowercase English letters only)
        int[] charCounts = new int[256];

        // Pass 1: Count frequencies
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
        }

        // Pass 2: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (charCounts[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }

        return '_'; // Return placeholder if all characters repeat
    }

    // 2. Optimal Approach for Integer Arrays (LinkedHashMap)
    // Time: O(N), Space: O(U) where U is the number of unique elements
    public static int firstNonRepeatingInt(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        // LinkedHashMap preserves the order of insertion
        Map<Integer, Integer> counts = new LinkedHashMap<>();

        // Pass 1: Count frequencies
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Pass 2: Iterate through the map (which is in insertion order)
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        throw new RuntimeException("No non-repeating element found");
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- First Non-Repeating Element ---");

        // --- String Tests ---
        System.out.println("[String Tests]");
        String[] stringTests = {
                "leetcode",         // 'l' is first
                "loveleetcode",     // 'v' is first
                "aabb",             // None -> '_'
                "z"                 // 'z' is first
        };

        for (String test : stringTests) {
            System.out.println("  Input: \"" + test + "\" -> First Unique: '" + firstNonRepeatingChar(test) + "'");
        }

        System.out.println("\n[Integer Array Tests]");
        // --- Integer Array Tests ---
        int[][] arrayTests = {
                {9, 4, 9, 6, 7, 4}, // 9 and 4 repeat. 6 is first unique.
                {2, 3, 4, 2, 3, 4}, // All repeat -> Exception/Error
                {10, 10, 10, 5},    // 5 is first unique
                {-1, 2, -1, 3}      // -1 repeats, 2 is first unique
        };

        for (int[] test : arrayTests) {
            System.out.print("  Input: " + Arrays.toString(test) + " -> First Unique: ");
            try {
                System.out.println(firstNonRepeatingInt(test));
            } catch (RuntimeException e) {
                System.out.println("None");
            }
        }
    }
}