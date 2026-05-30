package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortedArrays {

    // 1. In-Place Merge (Optimal for arrays with buffer space)
    // Time: O(M + N), Space: O(1)
    // 'm' is the number of valid elements in nums1. 'n' is the number of elements in nums2.
    public static void mergeInPlace(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;         // Pointer for the last valid element in nums1
        int p2 = n - 1;         // Pointer for the last element in nums2
        int p = m + n - 1;      // Pointer for the very end of nums1 (the buffer zone)

        // While there are elements to compare in both arrays
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If nums2 still has elements left, copy them over.
        // (If nums1 has elements left, we do nothing because they are already in the correct place)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    // 2. New Array Merge (Optimal for standard arrays)
    // Time: O(M + N), Space: O(M + N) to hold the result
    public static int[] mergeNewArray(int[] arr1, int[] arr2) {
        if (arr1 == null) return arr2;
        if (arr2 == null) return arr1;

        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Traverse both arrays and insert the smaller element into the result
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy any remaining elements from arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy any remaining elements from arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    // 3. Stream Approach (Modern Java)
    // Time: O((M+N) log(M+N)) due to sorting, Space: O(M + N)
    public static int[] mergeStream(int[] arr1, int[] arr2) {
        if (arr1 == null) return arr2;
        if (arr2 == null) return arr1;

        // Concatenate streams and sort (note: ignores the fact that they are already sorted)
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sorted()
                .toArray();
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Merge Sorted Arrays ---");

        // --- Scenario A: In-Place Merge ---
        // nums1 has a length of 6, but only 3 valid elements.
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Scenario A: In-Place Merge (Right-to-Left)");
        System.out.println("  Input nums1: " + Arrays.toString(nums1) + " | Valid: " + m);
        System.out.println("  Input nums2: " + Arrays.toString(nums2) + " | Valid: " + n);

        mergeInPlace(nums1, m, nums2, n);
        System.out.println("  Result:      " + Arrays.toString(nums1));
        System.out.println();

        // --- Scenario B: New Array Merge ---
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10, 12};

        System.out.println("Scenario B: Out-of-Place Merge (Left-to-Right)");
        System.out.println("  Input arr1: " + Arrays.toString(arr1));
        System.out.println("  Input arr2: " + Arrays.toString(arr2));

        System.out.println("  Two Pointer Method: " + Arrays.toString(mergeNewArray(arr1, arr2)));
        System.out.println("  Stream Method:      " + Arrays.toString(mergeStream(arr1, arr2)));
    }
}