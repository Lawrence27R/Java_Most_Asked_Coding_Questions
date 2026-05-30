package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // 1. HashMap Approach (Optimal for Unsorted Arrays)
    // Time: O(N), Space: O(N)
    public static int[] findTwoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        // Map to store the number and its index: Map<Number, Index>
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If we have seen the complement before, we found our pair
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }

            // Otherwise, store the current number and its index
            numMap.put(nums[i], i);
        }

        // Return empty array if no pair is found
        return new int[]{};
    }

    // 2. Two-Pointer Approach (Optimal ONLY IF the array is already sorted)
    // Note: This returns the *values* rather than original indices, because
    // sorting the array ruins the original indices.
    // Time: O(N), Space: O(1)
    public static int[] findTwoSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];

            if (currentSum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (currentSum < target) {
                left++; // We need a larger sum, move left pointer up
            } else {
                right--; // We need a smaller sum, move right pointer down
            }
        }

        return new int[]{};
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Two Sum ---");

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Target: " + target + " | Array: " + Arrays.toString(nums));

        // Output for Unsorted/HashMap method (Returns Indices)
        int[] resultIndices = findTwoSum(nums, target);
        System.out.println("HashMap Method (Indices): " + Arrays.toString(resultIndices));
        // Expected: [0, 1]

        // Output for Sorted/Two-Pointer method (Returns Values)
        int[] resultValues = findTwoSumSorted(nums, target);
        System.out.println("Two-Pointer Method (Values): " + Arrays.toString(resultValues));
        // Expected: [2, 7]
    }
}