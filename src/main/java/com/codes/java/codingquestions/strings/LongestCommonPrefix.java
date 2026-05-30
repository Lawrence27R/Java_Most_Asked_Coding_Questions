package com.codes.java.codingquestions.strings;

import java.util.Arrays;

public class LongestCommonPrefix {

    // 1. Without Streams (Optimal Horizontal Scanning: O(S) Time, O(1) Space)
    public static String findPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // While the current string doesn't start with the prefix...
            while (!strs[i].startsWith(prefix)) {
                // Chop off the last character of the prefix and try again
                prefix = prefix.substring(0, prefix.length() - 1);

                // Early exit: if the prefix shrinks to nothing, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // 2. With Streams (Reduction Approach: O(S) Time, O(1) Space)
    public static String findPrefixStream(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return Arrays.stream(strs)
                // reduce() continually takes the accumulated prefix and the next string
                .reduce((prefix, str) -> {
                    while (!str.startsWith(prefix)) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                    }
                    return prefix;
                })
                .orElse("");
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Longest Common Prefix ---");

        String[][] tests = {
                {"flower", "flow", "flight"},                   // Expected: "fl"
                {"interspecies", "interstellar", "interstate"}, // Expected: "inters"
                {"dog", "racecar", "car"},                      // Expected: "" (No common prefix)
                {"throne", "throne"},                           // Expected: "throne"
                {""},                                           // Expected: ""
                null                                            // Expected: ""
        };

        for (String[] test : tests) {
            String displayArr = (test == null) ? "null" : Arrays.toString(test);
            System.out.println("Input: " + displayArr);
            System.out.println("  Loop:   \"" + findPrefix(test) + "\"");
            System.out.println("  Stream: \"" + findPrefixStream(test) + "\"");
            System.out.println();
        }
    }
}