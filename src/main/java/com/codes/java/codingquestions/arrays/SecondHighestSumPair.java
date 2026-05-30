package com.codes.java.codingquestions.arrays;

import java.util.Arrays;

public class SecondHighestSumPair {

    // 1. Single Pass Approach (Optimal)
    // Time: O(N), Space: O(1)
    public static int[] findSecondHighestSumPair(int[] nums) {
        // We need at least 3 elements to guarantee a strictly *second* highest distinct sum.
        // (An array of 2 elements only has 1 sum).
        if (nums == null || nums.length < 3) {
            return new int[]{};
        }

        // Initialize the top 3 using the first 3 elements to avoid Integer.MIN_VALUE bugs
        int first = Math.max(nums[0], Math.max(nums[1], nums[2]));
        int third = Math.min(nums[0], Math.min(nums[1], nums[2]));
        int second = nums[0] + nums[1] + nums[2] - first - third; // Mathematical trick to get the middle

        // Scan the rest of the array to maintain the top 3 largest elements
        for (int i = 3; i < nums.length; i++) {
            int num = nums[i];
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        // Calculate the maximum possible sum
        int maxSum = first + second;
        int secondMaxSum = Integer.MIN_VALUE;
        int[] resultPair = new int[]{};

        // The second highest sum must be either (first + third) or (second + third)
        if (first + third < maxSum) {
            secondMaxSum = first + third;
            resultPair = new int[]{first, third};
        }

        if (second + third < maxSum && second + third > secondMaxSum) {
            // secondMaxSum = second + third; // Only needed if you return the sum
            resultPair = new int[]{second, third};
        }

        return resultPair;
    }

    // 2. Sorting Approach
    // Time: O(N log N), Space: O(1)
    public static int[] findSecondHighestSumPairSorted(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[]{};
        }

        // Copy array so we don't mutate the original test cases
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int n = sortedNums.length;
        int first = sortedNums[n - 1];
        int second = sortedNums[n - 2];
        int third = sortedNums[n - 3];

        int maxSum = first + second;
        int secondMaxSum = Integer.MIN_VALUE;
        int[] resultPair = new int[]{};

        if (first + third < maxSum) {
            secondMaxSum = first + third;
            resultPair = new int[]{first, third};
        }
        if (second + third < maxSum && second + third > secondMaxSum) {
            resultPair = new int[]{second, third};
        }

        return resultPair;
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Find Pair with Second Highest Sum ---");

        int[][] tests = {
                {10, 8, 5, 2},      // Top 3: 10, 8, 5. Max: 18. Second Max: 15. Pair: [10, 5]
                {10, 9, 9, 8},      // Top 3: 10, 9, 9. Max: 19. Second Max: 18. Pair: [9, 9]
                {10, 10, 9, 8},     // Top 3: 10, 10, 9. Max: 20. Second Max: 19. Pair: [10, 9]
                {7, 7, 7},          // All same. Max: 14. Second Max: None. Pair: []
                {-5, -2, -10, -1},  // Negatives. Top 3: -1, -2, -5. Max: -3. Second Max: -6. Pair: [-1, -5]
                {4, 5}              // Less than 3 elements. Pair: []
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));

            int[] resultOptimal = findSecondHighestSumPair(test);
            int[] resultSorted = findSecondHighestSumPairSorted(test);

            System.out.println("  Single Pass (O(N)): " + Arrays.toString(resultOptimal));
            System.out.println("  Sorting (O(N log N)): " + Arrays.toString(resultSorted));
            System.out.println();
        }
    }
}