package com.codes.java.codingquestions.strings;

public class WhitespaceRemover {

    // 1. Without Streams (Optimal Iteration: O(n) Time, O(n) Space)
    public static String remove(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Initialize StringBuilder with original length to prevent array resizing overhead
        StringBuilder sb = new StringBuilder(str.length());

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Character.isWhitespace catches spaces, tabs, newlines, etc.
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // 2. With Streams (Primitive Stream: O(n) Time, O(n) Space)
    public static String removeStream(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.chars() // Generate IntStream of characters
                .filter(c -> !Character.isWhitespace(c)) // Keep only non-whitespaces
                // Collect directly into StringBuilder using primitive appendCodePoint
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    // 3. The Production Approach (Regex)
    public static String removeRegex(String str) {
        if (str == null) return null;

        // \\s+ matches one or more whitespace characters and replaces them with nothing
        return str.replaceAll("\\s+", "");
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Remove Whitespaces ---");

        String[] tests = {
                "hello world",           // Standard space
                "  java   programming ", // Multiple spaces and leading/trailing
                "tab\tseparated\twords", // Tabs
                "multi\nline\rstring",   // Newlines and carriage returns
                "nospaces",              // No changes needed
                "",
                null
        };

        for (String test : tests) {
            // Format the output string so tabs/newlines are visible in the console
            String displayStr = (test == null) ? "null"
                    : "\"" + test.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") + "\"";

            System.out.println("Input: " + displayStr);
            System.out.println("  Loop:   \"" + remove(test) + "\"");
            System.out.println("  Stream: \"" + removeStream(test) + "\"");
            System.out.println("  Regex:  \"" + removeRegex(test) + "\"");
            System.out.println();
        }
    }
}