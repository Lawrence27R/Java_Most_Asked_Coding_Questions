package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // 1. Boyer-Moore Voting Algorithm (Most Optimal)
    // Time: O(N), Space: O(1)
    public static int findMajorityBoyerMoore(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // If our count drops to zero, we elect a new candidate
            if (count == 0) {
                candidate = num;
            }

            // If the current number is our candidate, reinforce them.
            // Otherwise, they fight and cancel each other out.
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Note: The problem guarantees a majority element exists.
        // If it didn't, we would need a second pass here to verify
        // that our 'candidate' actually appears more than n/2 times.
        return candidate;
    }

    // 2. HashMap Approach (Good for interviews if you forget Boyer-Moore)
    // Time: O(N), Space: O(N)
    public static int findMajorityHashMap(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int majorityThreshold = nums.length / 2;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);

            // As soon as we cross the threshold, return it
            if (counts.get(num) > majorityThreshold) {
                return num;
            }
        }

        return -1;
    }

    // 3. Sorting Approach (Simplest code)
    // Time: O(N log N), Space: O(1) or O(N) depending on the sorting algorithm
    public static int findMajoritySorting(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        // Sort the array (modifies original array, ask interviewer if this is allowed!)
        Arrays.sort(nums);

        // The majority element will always be at the middle index
        return nums[nums.length / 2];
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Majority Element ---");

        int[][] tests = {
                {3, 2, 3},                   // Majority: 3
                {2, 2, 1, 1, 1, 2, 2},       // Majority: 2
                {6, 5, 5},                   // Majority: 5
                {1}                          // Majority: 1
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));

            // Note: We don't copy arrays here except for the sorting method to prevent mutation
            int[] testForSort = Arrays.copyOf(test, test.length);

            System.out.println("  Boyer-Moore: " + findMajorityBoyerMoore(test));
            System.out.println("  HashMap:     " + findMajorityHashMap(test));
            System.out.println("  Sorting:     " + findMajoritySorting(testForSort));
            System.out.println();
        }
    }
}