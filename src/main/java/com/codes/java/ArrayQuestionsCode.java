package com.codes.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayQuestionsCode {

//         Odd Even Numbers
//    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    public static void findOddEvenNumbers(int[] nums) {

        List<Integer> evenNumbers = Arrays.stream(nums)
                .boxed()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = Arrays.stream(nums)
                .boxed()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers : " + oddNumbers);
    }

//    Largest and Second Largest Element
//    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    public static int[] findLargestAndSecondLargest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("  Warning: No distinct second largest element exists.");
        }

        return new int[]{largest, secondLargest};
    }

//    Swamp Zeros
//    int[] arr = {0, 1, 0, 3, 12}
    public static void moveZeroesSwap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                insertPos++;
            }
        }
    }

//    Sort Array
    public static int[] sortAscendingStream(int[] arr) {
        if (arr == null) {
            return null;
        }
        return Arrays.stream(arr)
                .sorted()
                .toArray();
    }

//    Sort Array Descending
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

//    Remove Duplicates from array
    public static int[] removeDuplicatesUnsorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }
        int[] result = new int[uniqueSet.size()];
        int i = 0;
        for (int num : uniqueSet) {
            result[i++] = num;
        }
        return result;
    }
    public static int[] removeDuplicatesStream(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        return Arrays.stream(nums).distinct().toArray();
    }

//    Missing Numbers
    public static int findMissingNumberStream(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }

//    Merge Sorted Arrays
    public static int[] mergeStream(int[] arr1, int[] arr2) {
        if (arr1 == null) return arr2;
        if (arr2 == null) return arr1;

        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sorted()
                .toArray();
    }

//    First Non Reapting in Array
    public static int firstNonRepeatingInt(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        Map<Integer, Integer> counts = new LinkedHashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No non-repeating element found");
    }

//    Contains Duplicates
    public static boolean containsDuplicateStream(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        return Arrays.stream(nums).distinct().count() != nums.length;
    }

//    Second Highest Sum Pair in Array
    public static int[] findSecondHighestSumPairSorted(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[]{};
        }

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int n = sortedNums.length;
        int first = sortedNums[n - 1];
        int second = sortedNums[n - 2];
        int third = sortedNums[n - 3];

        int maxSum = first + second;
        int secondMaxSum = Integer.MIN_VALUE;
        int[] resultPair = new int[]{};

        if (first + third < maxSum) {
            secondMaxSum = first + third;
            resultPair = new int[]{first, third};
        }
        if (second + third < maxSum && second + third > secondMaxSum) {
            resultPair = new int[]{second, third};
        }

        return resultPair;
    }

//    Product Array Except Self
    public static int[] productExceptSelfTwoArrays(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] result = new int[n];

        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

//    InterSection of two arrays
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

//    Buy and Sell Stocks
//    int[][] tests = {
//            {7, 1, 5, 3, 6, 4}, // Buy at 1 (Day 2), Sell at 6 (Day 5) -> Profit: 5
//            {7, 6, 4, 3, 1},    // Prices only drop, no profit possible -> Profit: 0
//            {2, 4, 1},          // Buy at 2, Sell at 4 -> Profit: 2 (Cannot sell before buying)
//            {2},                // Not enough days to buy and sell -> Profit: 0
//            {1, 2, 3, 4, 5}     // Buy at 1, Sell at 5 -> Profit: 4
//    };
    public static int findMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE; // Track the lowest buying price
        int maxProfit = 0;                // Track the maximum profit we can make

        for (int i = 0; i < prices.length; i++) {
            // If we found a new cheaper buying price, update it
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Otherwise, check if selling today yields a better profit
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

}
