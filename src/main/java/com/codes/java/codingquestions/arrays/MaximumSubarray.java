package com.codes.java.codingquestions.arrays;

import java.util.Arrays;

public class MaximumSubarray {

    // 1. Standard Kadane's Algorithm (Returns the maximum sum)
    // Time: O(N), Space: O(1)
    public static int findMaxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Or throw an IllegalArgumentException
        }

        int currentMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Do we extend the previous subarray, or start a new one here?
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Did this choice give us a new global maximum?
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    // 2. Enhanced Kadane's Algorithm (Returns the actual subarray elements)
    // Time: O(N), Space: O(1) auxiliary (O(K) to return the result array)
    public static int[] findMaxSubarrayElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int currentMax = nums[0];
        int maxSoFar = nums[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            // If the current element alone is greater than the running sum + current element,
            // we drop the running sum and start a new subarray.
            if (nums[i] > currentMax + nums[i]) {
                currentMax = nums[i];
                tempStart = i; // Mark the potential start of a new max subarray
            } else {
                currentMax += nums[i];
            }

            // If we found a new global maximum, record the bounds
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        // Return a copy of the original array using the recorded bounds
        return Arrays.copyOfRange(nums, start, end + 1);
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Maximum Subarray (Kadane's Algorithm) ---");

        int[][] tests = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4}, // Classic test: Max is [4, -1, 2, 1] = 6
                {1},                             // Single element: Max is [1] = 1
                {5, 4, -1, 7, 8},                // All positive-ish: Max is [5, 4, -1, 7, 8] = 23
                {-5, -2, -9, -1}                 // All negative: Max is [-1] = -1
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));

            int maxSum = findMaxSubarraySum(test);
            int[] maxSubarray = findMaxSubarrayElements(test);

            System.out.println("  Max Sum:      " + maxSum);
            System.out.println("  Max Subarray: " + Arrays.toString(maxSubarray));
            System.out.println();
        }
    }
}