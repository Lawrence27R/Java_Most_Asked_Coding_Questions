package com.codes.java.codingquestions.arrays;

import java.util.Arrays;

public class MissingNumber {

    // 1. Math Approach (Sum Formula)
    // Time: O(N), Space: O(1)
    public static int findMissingNumberMath(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        // Formula for the sum of the first n numbers
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // 2. Bit Manipulation Approach (XOR) - Safest against integer overflow
    // Time: O(N), Space: O(1)
    public static int findMissingNumberXOR(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int missing = n; // Initialize to n because the loop below only goes up to n - 1

        for (int i = 0; i < n; i++) {
            // XOR the index and the value at that index
            missing ^= i ^ nums[i];
        }

        return missing;
    }

    // 3. Stream Approach (Modern Java)
    // Time: O(N), Space: O(1)
    public static int findMissingNumberStream(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        // Sum all elements using an IntStream
        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Missing Number ---");

        int[][] tests = {
                {3, 0, 1},                   // Missing 2
                {0, 1},                      // Missing 2
                {9, 6, 4, 2, 3, 5, 7, 0, 1}, // Missing 8
                {0}                          // Missing 1
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));

            System.out.println("  Math Method:   " + findMissingNumberMath(test));
            System.out.println("  XOR Method:    " + findMissingNumberXOR(test));
            System.out.println("  Stream Method: " + findMissingNumberStream(test));
            System.out.println();
        }
    }
}