package com.codes.java.codingquestions.strings;

import java.util.Arrays;
import java.util.stream.Stream;

public class FibonacciSeries {

    // 1. Without Streams (Optimal Iterative: O(n) Time, O(n) Space)
    public static void generate(int n) {

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        int firstTerm = 0;
        int secondTerm = 1;
        System.out.println("Fibonacci Series till " + n + " terms:");

        for (int i = 1; i <= n; i++) {
            System.out.print(firstTerm);
            if (i < n) {
                System.out.print(", ");
            }
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }

    // 2. With Streams (Iterate approach: O(n) Time, O(n) Space)
    public static long[] generateStream(int n) {
        if (n <= 0) return new long[0];

        return Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]})
                .limit(n)
                .mapToLong(t -> t[0])
                .toArray();
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Fibonacci Series ---");
        generate(10);
//        int[] tests = {0, 1, 5, 10};
//
//        for (int n : tests) {
//            System.out.println("n=" + n + " | Loop: " + Arrays.toString(generate(n)));
//            System.out.println("n=" + n + " | Stream: " + Arrays.toString(generateStream(n)));
//        }
    }
}