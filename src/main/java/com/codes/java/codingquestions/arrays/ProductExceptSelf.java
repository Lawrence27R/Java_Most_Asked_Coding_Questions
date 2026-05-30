package com.codes.java.codingquestions.arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    // 1. Optimal Approach (O(N) Time, O(1) Extra Space)
    // Note: The output array does not count as extra space for complexity analysis.
    public static int[] productExceptSelfOptimal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate left products
        // Initialize the first element as 1 since there is nothing to the left of index 0
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i]; // Update running left product for the NEXT index
        }

        // Step 2: Calculate right products and multiply on the fly
        // Initialize the right product as 1 since there is nothing to the right of the last index
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Multiply the stored left product by the running right product
            result[i] *= rightProduct;
            rightProduct *= nums[i]; // Update running right product for the NEXT index
        }

        return result;
    }

    // 2. Alternative Approach: Two Arrays (O(N) Time, O(N) Space)
    // This is mathematically the same, but easier to explain if you get stuck.
    public static int[] productExceptSelfTwoArrays(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] result = new int[n];

        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Product of Array Except Self ---");

        int[][] tests = {
                {1, 2, 3, 4},       // Standard case -> [24, 12, 8, 6]
                {-1, 1, 0, -3, 3},  // Contains a single zero -> [0, 0, 9, 0, 0]
                {0, 4, 0},          // Contains multiple zeroes -> [0, 0, 0]
                {5, 9}              // Two elements -> [9, 5]
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));
            System.out.println("  Optimal O(1) Space: " + Arrays.toString(productExceptSelfOptimal(test)));
            System.out.println("  Two Arrays O(N):    " + Arrays.toString(productExceptSelfTwoArrays(test)));
            System.out.println();
        }
    }
}