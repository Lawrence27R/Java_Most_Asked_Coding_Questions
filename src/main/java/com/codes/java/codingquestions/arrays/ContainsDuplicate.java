package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // 1. HashSet Approach (Optimal for Time)
    // Time: O(N), Space: O(N)
    public static boolean containsDuplicateHashSet(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            // Set.add() returns false if the element was already present
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    // 2. Sorting Approach (Optimal for Space, but slower)
    // Time: O(N log N), Space: O(1) auxiliary (assuming in-place sort)
    public static boolean containsDuplicateSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        // We copy the array here purely to avoid mutating the test cases.
        // In an interview, ask if you are allowed to modify the original array!
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        for (int i = 0; i < sortedNums.length - 1; i++) {
            if (sortedNums[i] == sortedNums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // 3. Stream Approach (Modern Java, One-Liner)
    // Time: O(N), Space: O(N)
    public static boolean containsDuplicateStream(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        // If the count of distinct elements does not match the total length,
        // there must be a duplicate.
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Contains Duplicate ---");

        int[][] tests = {
                {1, 2, 3, 1},                   // Contains duplicate (1) -> true
                {1, 2, 3, 4},                   // All distinct -> false
                {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, // Many duplicates -> true
                {5},                            // Single element -> false
                {}                              // Empty array -> false
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));

            System.out.println("  HashSet Method: " + containsDuplicateHashSet(test));
            System.out.println("  Sorting Method: " + containsDuplicateSort(test));
            System.out.println("  Stream Method:  " + containsDuplicateStream(test));
            System.out.println();
        }
    }
}