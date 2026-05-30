package com.codes.java.codingquestions.arrays;

import java.util.Arrays;

public class RotateArray {

    // 1. Array Reversal Approach (Most Optimal: In-Place)
    // Time: O(N), Space: O(1)
    public static void rotateReversal(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }

        int n = nums.length;
        k = k % n; // Crucial: Handle cases where k > array length

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n - k elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse a portion of the array in-place
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 2. Extra Array Approach
    // Time: O(N), Space: O(N)
    public static void rotateExtraArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }

        int n = nums.length;
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            // Calculate the new index wrapped around the array length
            rotated[(i + k) % n] = nums[i];
        }

        // Copy the rotated elements back into the original array
        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Rotate Array ---");

        int[][] tests = {
                {1, 2, 3, 4, 5, 6, 7}, // Standard case
                {-1, -100, 3, 99},     // Contains negatives
                {1, 2},                // Small array
                {1}                    // Single element
        };
        int[] ks = {3, 2, 3, 0};       // k values corresponding to the tests

        for (int i = 0; i < tests.length; i++) {
            int[] test = tests[i];
            int k = ks[i];

            System.out.println("Input Array: " + Arrays.toString(test) + " | k = " + k);

            // Copy arrays to demonstrate both methods independently
            int[] testForReversal = Arrays.copyOf(test, test.length);
            int[] testForExtraArr = Arrays.copyOf(test, test.length);

            rotateReversal(testForReversal, k);
            rotateExtraArray(testForExtraArr, k);

            System.out.println("  Reversal Method: " + Arrays.toString(testForReversal));
            System.out.println("  Extra Array:     " + Arrays.toString(testForExtraArr));
            System.out.println();
        }
    }
}