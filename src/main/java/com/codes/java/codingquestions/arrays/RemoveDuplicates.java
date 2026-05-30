package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    // 1. Two Pointers (Optimal for Sorted Arrays - In-Place)
    // Time: O(N), Space: O(1)
    // Returns the number of unique elements (the new "length" of the valid array)
    public static int removeDuplicatesSorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // The first element is always unique, so we start inserting at index 1
        int insertIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one, it's unique
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }

        return insertIndex;
    }

    // 2. LinkedHashSet Approach (Optimal for Unsorted Arrays - Preserves Order)
    // Time: O(N), Space: O(N)
    // Returns a completely new array without duplicates
    public static int[] removeDuplicatesUnsorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }

        // Convert the Set back to an array
        int[] result = new int[uniqueSet.size()];
        int i = 0;
        for (int num : uniqueSet) {
            result[i++] = num;
        }
        return result;
    }

    // 3. Stream Approach (Modern Java for Unsorted/Sorted)
    // Time: O(N), Space: O(N)
    public static int[] removeDuplicatesStream(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        return Arrays.stream(nums).distinct().toArray();
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Remove Duplicates ---");

        // --- Test Scenario A: Sorted Array (In-Place) ---
        int[] sortedNums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Input (Sorted):   " + Arrays.toString(sortedNums));

        int uniqueCount = removeDuplicatesSorted(sortedNums);

        // To show the result, we only print up to the 'uniqueCount' index
        int[] validResult = Arrays.copyOfRange(sortedNums, 0, uniqueCount);
        System.out.println("  In-Place Result:  " + Arrays.toString(validResult) + " | New Length: " + uniqueCount);
        System.out.println();

        // --- Test Scenario B: Unsorted Array (Returns New Array) ---
        int[][] unsortedTests = {
                {4, 2, 4, 1, 2, 3, 1},
                {7, 7, 7, 7}
        };

        for (int[] test : unsortedTests) {
            System.out.println("Input (Unsorted): " + Arrays.toString(test));
            System.out.println("  LinkedHashSet:    " + Arrays.toString(removeDuplicatesUnsorted(test)));
            System.out.println("  Stream Method:    " + Arrays.toString(removeDuplicatesStream(test)));
            System.out.println();
        }
    }
}