package com.codes.java.codingquestions.strings;

import java.util.stream.IntStream;

public class PalindromeChecker {

    // 1. Without Streams (Optimal Two-Pointer: O(n) Time, O(1) Space)
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        if (str.length() <= 1) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2. With Streams (Optimal IntStream: O(n) Time, O(1) Space)
    public static boolean isPalindromeStream(String str) {
        if (str == null) return false;
        int len = str.length();
        if (len <= 1) return true;

        // Only check up to the middle of the string
        return IntStream.range(0, len / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(len - i - 1));
    }

    // Test Cases
    public static void run() {
        System.out.println("--- Palindrome Checker ---");
        String[] tests = {"racecar", "Lawrence", "a", "", null};

        for (String test : tests) {
            System.out.println("Input: " + test +
                    " | Pointer: " + isPalindrome(test) +
                    " | Stream: " + isPalindromeStream(test));
        }
    }
}