package com.codes.java.codingquestions.strings;

import java.util.stream.Collectors;

public class UnderscoreAdder {

    // 1. Without Streams (Optimal Iteration: O(n) Time, O(n) Space)
    public static String addUnderscores(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // When we find an uppercase letter...
            if (Character.isUpperCase(c)) {
                // Add an underscore, but ONLY if it's not the very first character
                if (i > 0 && sb.charAt(sb.length() - 1) != '_') {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // 2. With Streams (Functional Mapping: O(n) Time, O(n) Space)
    public static String addUnderscoresStream(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Isolate the first character to prevent placing a leading underscore (e.g., "_java_code")
        String firstChar = String.valueOf(Character.toLowerCase(str.charAt(0)));

        return firstChar + str.substring(1).chars()
                .mapToObj(c -> (char) c)
                .map(c -> Character.isUpperCase(c) ? "_" + Character.toLowerCase(c) : String.valueOf(c))
                .collect(Collectors.joining());
    }

    // 3. The Production Approach (Regex)
    public static String addUnderscoresRegex(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Find boundaries where a lowercase letter is immediately followed by an uppercase letter
        return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Add Underscores (CamelCase to snake_case) ---");

        String[] tests = {
                "javaCodingQuestion", // Standard camelCase
                "PascalCaseString",   // Standard PascalCase (Starts with capital)
                "already_snake_case", // No changes needed
                "a",                  // Single character
                "",
                null
        };

        for (String test : tests) {
            String displayStr = (test == null) ? "null" : "\"" + test + "\"";
            System.out.println("Input: " + displayStr);
            System.out.println("  Loop:   \"" + addUnderscores(test) + "\"");
            System.out.println("  Stream: \"" + addUnderscoresStream(test) + "\"");
            System.out.println("  Regex:  \"" + addUnderscoresRegex(test) + "\"");
            System.out.println();
        }
    }
}