package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestAndSecondLargest {

    // 1. Optimal Approach (Single Pass)
    // Time: O(N), Space: O(1)
    public static int[] findLargestAndSecondLargest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                // The current largest gets demoted to second largest
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                // We found a number strictly smaller than the largest,
                // but bigger than our current second largest
                secondLargest = num;
            }
        }

        // If secondLargest is still MIN_VALUE, it means all elements were identical
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("  Warning: No distinct second largest element exists.");
        }

        return new int[]{largest, secondLargest};
    }

    // 2. Stream Approach (Modern Java)
    // Time: O(N log N) due to sorting, Space: O(N) for boxing/streams
    public static int[] findLargestAndSecondLargestStream(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int largest = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);

        // Find second largest by making elements distinct, sorting descending, and skipping 1
        int secondLargest = Arrays.stream(nums)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(Integer.MIN_VALUE);

        return new int[]{largest, secondLargest};
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Largest and Second Largest Element ---");

        int[][] tests = {
                {12, 35, 1, 10, 34, 1}, // Standard case: Largest 35, Second 34
                {10, 5, 10},            // Duplicate highest: Largest 10, Second 5
                {7, 7, 7},              // All identical elements (Edge case)
                {-10, -40, -20, -5}     // All negative elements
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));

            int[] resultTraditional = findLargestAndSecondLargest(test);
            int[] resultStream = findLargestAndSecondLargestStream(test);

            System.out.println("  Traditional Method: Largest = " + resultTraditional[0] +
                    ", Second = " + (resultTraditional[1] == Integer.MIN_VALUE ? "None" : resultTraditional[1]));
            System.out.println("  Stream Method:      Largest = " + resultStream[0] +
                    ", Second = " + (resultStream[1] == Integer.MIN_VALUE ? "None" : resultStream[1]));
            System.out.println();
        }
    }
}