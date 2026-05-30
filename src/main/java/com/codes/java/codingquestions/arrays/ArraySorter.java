package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArraySorter {

    // 1. Without Streams (Optimal: O(n log n) Time, O(1) Auxiliary Space for in-place sorting)
    // Note: We use Arrays.copyOf here purely so we don't mutate the original test arrays.
    public static int[] sortAscending(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    public static int[] sortDescending(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        // Reverse the array in-place
        int left = 0;
        int right = sortedArr.length - 1;
        while (left < right) {
            int temp = sortedArr[left];
            sortedArr[left] = sortedArr[right];
            sortedArr[right] = temp;
            left++;
            right--;
        }
        return sortedArr;
    }

    // 2. With Streams (Modern Approach: O(n log n) Time, O(n) Space overhead for boxing/arrays)
    public static int[] sortAscendingStream(int[] arr) {
        if (arr == null) {
            return null;
        }
        return Arrays.stream(arr)
                .sorted()
                .toArray();
    }

    public static int[] sortDescendingStream(int[] arr) {
        if (arr == null) {
            return null;
        }
        return Arrays.stream(arr)
                .boxed() // Convert IntStream to Stream<Integer>
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue) // Unbox back to IntStream
                .toArray();
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Array Sorter (Ascending & Descending) ---");
        int[][] tests = {
                {5, 2, 8, 1, 9, 3},
                {10, -2, 4, 0},
                {7, 7, 7},
                {},
                null
        };

        for (int[] test : tests) {
            String original = (test == null) ? "null" : Arrays.toString(test);
            System.out.println("Input Array: " + original);

            System.out.println("  [Ascending]  Traditional: " + Arrays.toString(sortAscending(test)) +
                    " | Stream: " + Arrays.toString(sortAscendingStream(test)));

            System.out.println("  [Descending] Traditional: " + Arrays.toString(sortDescending(test)) +
                    " | Stream: " + Arrays.toString(sortDescendingStream(test)));
            System.out.println();
        }
    }
}
