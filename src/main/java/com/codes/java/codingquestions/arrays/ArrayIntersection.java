package com.codes.java.codingquestions.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    // 1. HashSet Approach (Optimal for Time)
    // Time: O(M + N), Space: O(M) where M is the length of nums1
    public static int[] intersectionHashSet(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        // Convert the Set back to an int[] array
        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (int num : intersectionSet) {
            result[i++] = num;
        }

        return result;
    }

    // 2. Sorting & Two Pointers Approach (Optimal for Memory constraints)
    // Time: O(M log M + N log N), Space: O(1) auxiliary (ignoring result array)
    public static int[] intersectionTwoPointers(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        // Copying arrays purely so we don't mutate the test cases
        int[] sorted1 = Arrays.copyOf(nums1, nums1.length);
        int[] sorted2 = Arrays.copyOf(nums2, nums2.length);

        Arrays.sort(sorted1);
        Arrays.sort(sorted2);

        Set<Integer> intersectionSet = new HashSet<>();
        int i = 0;
        int j = 0;

        while (i < sorted1.length && j < sorted2.length) {
            if (sorted1[i] < sorted2[j]) {
                i++;
            } else if (sorted1[i] > sorted2[j]) {
                j++;
            } else {
                // They match! Add to our unique set and move both pointers
                intersectionSet.add(sorted1[i]);
                i++;
                j++;
            }
        }

        // Convert the Set back to an array
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }

    // 3. Stream Approach (Modern Java)
    // Time: O(M + N), Space: O(M)
    public static int[] intersectionStream(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[]{};

        // Convert nums1 to a List/Set for the stream filter to use
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);

        return Arrays.stream(nums2)
                .distinct()
                .filter(set1::contains)
                .toArray();
    }

    // Test Cases
    public static void run() {
        System.out.println("\n--- Find Intersection of Two Arrays ---");

        int[][][] tests = {
                {{1, 2, 2, 1}, {2, 2}},             // Standard duplicate case -> [2]
                {{4, 9, 5}, {9, 4, 9, 8, 4}},       // Standard mixed case -> [4, 9] or [9, 4]
                {{1, 2, 3}, {4, 5, 6}},             // No intersection -> []
                {{1, 1, 1}, {1, 1}}                 // All same elements -> [1]
        };

        for (int[][] test : tests) {
            int[] nums1 = test[0];
            int[] nums2 = test[1];

            System.out.println("Input nums1: " + Arrays.toString(nums1));
            System.out.println("Input nums2: " + Arrays.toString(nums2));

            System.out.println("  HashSet Method:      " + Arrays.toString(intersectionHashSet(nums1, nums2)));
            System.out.println("  Two Pointers Method: " + Arrays.toString(intersectionTwoPointers(nums1, nums2)));
            System.out.println("  Stream Method:       " + Arrays.toString(intersectionStream(nums1, nums2)));
            System.out.println();
        }
    }
}