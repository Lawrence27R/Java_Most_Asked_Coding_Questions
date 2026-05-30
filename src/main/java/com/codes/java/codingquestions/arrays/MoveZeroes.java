package com.codes.java.codingquestions.arrays;

import java.util.Arrays;

public class MoveZeroes {

    // 1. Single Pass Approach (Swapping)
    // Time: O(N), Space: O(1)
    public static void moveZeroesSwap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap the non-zero element to the insert position
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                insertPos++;
            }
        }
    }

    // 2. Two Pass Approach (Overwrite then Fill)
    // Time: O(N), Space: O(1)
    public static void moveZeroesOverwrite(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int insertPos = 0;

        // Pass 1: Shift all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // Pass 2: Fill the remaining indices with zeroes
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Move Zeroes ---");

        int[][] tests = {
                {0, 1, 0, 3, 12},
                {0},
                {1, 2, 3},
                {0, 0, 0, 1},
                {4, 2, 0, 1, 0}
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));

            // Copy arrays so the first method doesn't ruin the test case for the second
            int[] testForSwap = Arrays.copyOf(test, test.length);
            int[] testForOverwrite = Arrays.copyOf(test, test.length);

            moveZeroesSwap(testForSwap);
            moveZeroesOverwrite(testForOverwrite);

            System.out.println("  Single Pass (Swap):       " + Arrays.toString(testForSwap));
            System.out.println("  Two Pass    (Overwrite):  " + Arrays.toString(testForOverwrite));
            System.out.println();
        }
    }
}