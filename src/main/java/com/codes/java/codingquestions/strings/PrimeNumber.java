package com.codes.java.codingquestions.strings;

import java.util.stream.IntStream;

public class PrimeNumber {

    // 1. Without Streams (Optimal Math: O(√n) Time, O(1) Space)
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false; // fast check for even numbers

        // Check odd numbers up to the square root of n
//        sqrt bcoz factors repeat after
//        +2 because all even numbers are already removed
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 2. With Streams (Optimal IntStream: O(√n) Time, O(1) Space)
    public static boolean isPrimeStream(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;

        // rangeClosed creates a stream from 2 to √n
        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Prime Number Checker ---");
        int[] tests = {-5, 0, 1, 2, 3, 4, 17, 100};

        for (int test : tests) {
            System.out.println("Input: " + test +
                    " | Loop: " + isPrime(test) +
                    " | Stream: " + isPrimeStream(test));
        }
    }
}