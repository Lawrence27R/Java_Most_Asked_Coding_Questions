package com.codes.java;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayCodingQuestionsCode {

    // ============================================================================
    // Question: Find Largest Element
    // Input : {10, 20, 30, 40, 50}
    // Output: 50
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findLargest(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int largest = arr[0];

        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }

        return largest;
    }

    // ============================================================================
    // Question: Find Smallest Element
    // Input : {10, 20, 30, 40, 50}
    // Output: 10
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findSmallest(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int smallest = arr[0];

        for (int num : arr) {
            if (num < smallest) {
                smallest = num;
            }
        }

        return smallest;
    }

    // ============================================================================
    // Question: Find Second Largest Element
    // Input : {10, 20, 30, 40, 50}
    // Output: 40
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findSecondLargest(int[] arr) {

        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException("Array must have at least 2 elements");

        int largest       = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE)
            throw new IllegalArgumentException("No second largest element exists");

        return secondLargest;
    }

    // ============================================================================
    // Question: Find Second Smallest Element
    // Input : {10, 20, 30, 40, 50}
    // Output: 20
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findSecondSmallest(int[] arr) {

        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException("Array must have at least 2 elements");

        int smallest       = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE)
            throw new IllegalArgumentException("No second smallest element exists");

        return secondSmallest;
    }

    // ============================================================================
    // Question: Reverse Array
    // Input : {1, 2, 3, 4, 5}
    // Output: {5, 4, 3, 2, 1}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void reverseArray(int[] arr) {

        if (arr == null || arr.length <= 1) return;

        int left  = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp   = arr[left];
            arr[left]  = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // ============================================================================
    // Question: Sum Of Array Elements
    // Input : {1, 2, 3, 4, 5}
    // Output: 15
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int sumOfElements(int[] arr) {

        if (arr == null) return 0;

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return sum;
    }

    // ============================================================================
    // Question: Average Of Array Elements
    // Input : {1, 2, 3, 4, 5}
    // Output: 3.0
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static double averageOfElements(int[] arr) {

        if (arr == null || arr.length == 0) return 0.0;

        return (double) sumOfElements(arr) / arr.length;
    }

    // ============================================================================
    // Question: Count Even And Odd Numbers
    // Input : {1, 2, 3, 4, 5, 6}
    // Output: Even = 3, Odd = 3
    // Time Complexity : O(n)
    // ============================================================================
    public static void countEvenOdd(int[] arr) {

        int even = 0;
        int odd  = 0;

        if (arr == null) {
            System.out.println("    Even Count : " + even);
            System.out.println("    Odd Count  : " + odd);
            return;
        }

        for (int num : arr) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("    Even Count : " + even);
        System.out.println("    Odd Count  : " + odd);
    }

    // ============================================================================
    // Question: Find Maximum And Minimum
    // Input : {10, 20, 30, 40, 50}
    // Output: Max = 50, Min = 10
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int[] findMaxAndMin(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        return new int[]{max, min};
    }

    // ============================================================================
    // Question: Search Element In Array
    // Input : {10, 20, 30, 40, 50}, target = 30
    // Output: true
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static boolean searchElement(int[] arr, int target) {

        if (arr == null) return false;

        for (int num : arr) {
            if (num == target) return true;
        }

        return false;
    }

    // ============================================================================
    // Question: Remove Duplicates From Array
    // Input : {1, 2, 2, 3, 4, 4, 5}
    // Output: [1, 2, 3, 4, 5]
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static int[] removeDuplicates(int[] arr) {

        if (arr == null) return new int[0];

        return Arrays.stream(arr).distinct().toArray();
    }

    // ============================================================================
    // Question: Find Duplicate Elements
    // Input : {1, 2, 2, 3, 4, 4, 5}
    // Output: [2, 4]
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Set<Integer> findDuplicates(int[] arr) {

        Set<Integer> seen       = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        if (arr == null) return duplicates;

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return duplicates;
    }

    // ============================================================================
    // Question: Frequency Of Elements
    // Input : {1, 2, 2, 3, 3, 3}
    // Output: {1=1, 2=2, 3=3}
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Map<Integer, Integer> frequencyCount(int[] arr) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        if (arr == null) return map;

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }

    // ============================================================================
    // Question: Missing Numbers In Array
    // Input : {1, 2, 4, 7, 10}
    // Output: [3, 5, 6, 8, 9]
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static List<Integer> findAllMissingNumbers(int[] arr) {

        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0) return result;

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        for (int i = 0; i < copy.length - 1; i++) {
            for (int num = copy[i] + 1; num < copy[i + 1]; num++) {
                result.add(num);
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Move Zeros To End
    // Input : {0, 1, 0, 3, 12}
    // Output: {1, 3, 12, 0, 0}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void moveZerosToEnd(int[] nums) {

        if (nums == null || nums.length <= 1) return;

        int nonZeroPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp         = nums[i];
                nums[i]          = nums[nonZeroPos];
                nums[nonZeroPos] = temp;
                nonZeroPos++;
            }
        }
    }

    // ============================================================================
    // Question: Rotate Array Left By One Position
    // Input : {1, 2, 3, 4, 5}
    // Output: {2, 3, 4, 5, 1}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void rotateLeft(int[] arr) {

        if (arr == null || arr.length <= 1) return;

        int first = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;
    }

    // ============================================================================
    // Question: Rotate Array Right By One Position
    // Input : {1, 2, 3, 4, 5}
    // Output: {5, 1, 2, 3, 4}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void rotateRight(int[] arr) {

        if (arr == null || arr.length <= 1) return;

        int last = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = last;
    }

    // ============================================================================
    // Question: Merge Two Arrays
    // Input : {1, 2, 3} and {4, 5, 6}
    // Output: {1, 2, 3, 4, 5, 6}
    // Time Complexity : O(n + m)
    // Space Complexity: O(n + m)
    // ============================================================================
    public static int[] mergeArrays(int[] arr1, int[] arr2) {

        return IntStream.concat(
                Arrays.stream(arr1 == null ? new int[0] : arr1),
                Arrays.stream(arr2 == null ? new int[0] : arr2)
        ).toArray();
    }

    // ============================================================================
    // Question: Intersection Of Arrays
    // Input : {1, 2, 3, 4, 5} and {4, 5, 6, 7}
    // Output: {4, 5}
    // Time Complexity : O(n + m)
    // Space Complexity: O(n)
    // ============================================================================
    public static int[] intersection(int[] arr1, int[] arr2) {

        if (arr1 == null || arr2 == null) return new int[0];

        Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());

        return Arrays.stream(arr2)
                .distinct()
                .filter(set::contains)
                .toArray();
    }

    // ============================================================================
    // Question: Union Of Arrays
    // Input : {1, 2, 3, 4, 5} and {4, 5, 6, 7}
    // Output: {1, 2, 3, 4, 5, 6, 7}
    // Time Complexity : O(n + m)
    // Space Complexity: O(n + m)
    // ============================================================================
    public static int[] union(int[] arr1, int[] arr2) {

        if (arr1 == null) arr1 = new int[0];
        if (arr2 == null) arr2 = new int[0];

        return IntStream.concat(
                        Arrays.stream(arr1),
                        Arrays.stream(arr2))
                .distinct()
                .toArray();
    }

    // ============================================================================
    // Question: Two Sum Problem
    // Input : {2, 7, 11, 15}, target = 9
    // Output: [0, 1]  (indices where arr[0]+arr[1] = 9)
    // Time Complexity : O(n^2)
    // Space Complexity: O(1)
    // ============================================================================
    public static List<int[]> allPairs(int[] nums, int target) {

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    // ============================================================================
    // Question: Pair With Given Sum
    // Input : {1, 2, 3, 4, 5}, target = 7
    // Output: [2, 5] and [3, 4]
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static List<int[]> findPairsWithSum(int[] arr, int target) {

        Set<Integer> set   = new HashSet<>();
        List<int[]>  result = new ArrayList<>();

        if (arr == null || arr.length < 2) return result;

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                result.add(new int[]{complement, num});
            }
            set.add(num);
        }

        return result;
    }

    // ============================================================================
    // Question: Maximum Subarray Sum  (Kadane's Algorithm)
    // Input : {-2, 1, -3, 4, -1, 2, 1, -5, 4}
    // Output: 6
    // Subarray = {4, -1, 2, 1}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void maxSubArray(int[] arr) {

        int currentSum = arr[0];
        int maxSum = arr[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Max Sum = " + maxSum);

        System.out.print("Subarray = [");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ============================================================================
    // Question: Subset Sum (Combination Sum)
    // Input : nums = {2, 7, 3, 6, 4, 5}, target = 9
    // Output: All combinations that sum to 9
    //         e.g. [2, 7], [3, 6], [4, 5], [2, 3, 4] ...
    // ============================================================================
    public static class SubsetSum {

        public static void findCombinations(int[] nums, int target) {
            System.out.println("    Combinations that sum to " + target + ":");
            backtrack(nums, target, 0, new ArrayList<>());
        }

        private static void backtrack(int[] nums,
                                      int target,
                                      int start,
                                      List<Integer> current) {

            if (target == 0) {
                System.out.println("    " + current);
                return;
            }

            if (target < 0) return;

            for (int i = start; i < nums.length; i++) {
                current.add(nums[i]);
                backtrack(nums, target - nums[i], i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    // ============================================================================
    // Question: Leaders In Array
    // Input : {16, 17, 4, 3, 5, 2}
    // Output: [17, 5, 2]
    // (A leader is greater than all elements to its right)
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static List<Integer> findLeaders(int[] arr) {

        List<Integer> leaders = new ArrayList<>();

        if (arr == null || arr.length == 0) return leaders;

        int maxFromRight = arr[arr.length - 1];
        leaders.add(maxFromRight);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(arr[i]);
            }
        }

        Collections.reverse(leaders);
        return leaders;
    }

    // ============================================================================
    // Question: Majority Element  (Boyer-Moore Voting Algorithm)
    // Input : {2, 2, 1, 1, 1, 2, 2}
    // Output: 2  (appears more than n/2 times)
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static Integer majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) return null;

        int candidate = 0;
        int count     = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        // Verify candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        return count > nums.length / 2 ? candidate : null;
    }

    // ============================================================================
    // Question: Sort 0s 1s 2s  (Dutch National Flag Algorithm)
    // Input : {2, 0, 2, 1, 1, 0}
    // Output: {0, 0, 1, 1, 2, 2}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void sortZeroOneTwo(int[] arr) {

        if (arr == null || arr.length <= 1) return;

        int low  = 0;
        int mid  = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            switch (arr[mid]) {

                case 0:
                    int temp0 = arr[low];
                    arr[low]  = arr[mid];
                    arr[mid]  = temp0;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    int temp2 = arr[mid];
                    arr[mid]  = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Array should contain only 0, 1, and 2");
            }
        }
    }

    // ============================================================================
    // Question: Product Of Array Except Self
    // Input : {1, 2, 3, 4}
    // Output: {24, 12, 8, 6}
    // (result[i] = product of all elements except arr[i])
    // Time Complexity : O(n^2)
    // Space Complexity: O(n)
    // ============================================================================
    public static int[] productExceptSelf(int[] nums) {

        int   n      = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    // ============================================================================
    // Question: Best Time To Buy And Sell Stock
    // Input : {7, 1, 5, 3, 6, 4}
    // Output: 5
    // Buy  = 1  (buy at lowest price)
    // Sell = 6  (sell at highest price after buy)
    // Profit = Sell - Buy = 6 - 1 = 5
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) return 0;

        int minPrice  = prices[0];
        int buyDay    = 0;
        int sellDay   = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
                buyDay   = i;
            }

            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
                sellDay   = i;
            }
        }

        System.out.println("    Buy  Day   : Day " + buyDay  + "  -> Price = " + prices[buyDay]);
        System.out.println("    Sell Day   : Day " + sellDay + "  -> Price = " + prices[sellDay]);
        System.out.println("    Max Profit : " + prices[sellDay] + " - " + prices[buyDay] + " = " + maxProfit);

        return maxProfit;
    }

    // ============================================================================
    // Question: First Non-Repeating Element
    // Input : {9, 4, 9, 6, 7, 4}
    // Output: 6
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static Integer firstNonRepeating(int[] arr) {

        if (arr == null || arr.length == 0) return null;

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    // ============================================================================
    // Question: Contains Duplicate
    // Input : {1, 2, 3, 1}
    // Output: true
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static boolean containsDuplicate(int[] arr) {

        if (arr == null || arr.length <= 1) return false;

        return Arrays.stream(arr).distinct().count() != arr.length;
    }

    // ============================================================================
    // Question: Sort Array Ascending (Using Stream)
    // Input : {5, 3, 8, 1, 2}
    // Output: {1, 2, 3, 5, 8}
    // ============================================================================
    public static int[] sortAscendingStream(int[] arr) {

        if (arr == null) return null;

        return Arrays.stream(arr).sorted().toArray();
    }

    // ============================================================================
    // Question: Sort Array Descending (Using Stream)
    // Input : {5, 3, 8, 1, 2}
    // Output: {8, 5, 3, 2, 1}
    // ============================================================================
    public static int[] sortDescendingStream(int[] arr) {

        if (arr == null) return null;

        return Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // ============================================================================
    // Question: Separate Odd and Even Numbers (Using Stream)
    // Input : {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    // Output: Even = [2, 4, 6, 8, 10]  Odd = [1, 3, 5, 7, 9]
    // ============================================================================
    public static void findOddEvenNumbers(int[] nums) {

        if (nums == null) return;

        List<Integer> evenNumbers = Arrays.stream(nums)
                .boxed()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = Arrays.stream(nums)
                .boxed()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("    Even Numbers : " + evenNumbers);
        System.out.println("    Odd Numbers  : " + oddNumbers);
    }

    // ============================================================================
    // Question: Next Greater Element
    // Input : {4, 5, 2, 10, 8}
    // Output: {5, 10, 10, -1, -1}
    // (For each element, find the first greater element to its right; -1 if none)
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // ============================================================================
    public static int[] nextGreaterElement(int[] nums) {

        if (nums == null) return new int[0];

        int[]           result = new int[nums.length];
        Stack<Integer>  stack  = new Stack<>();

        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }

    // ============================================================================
    // Question: Rotate Array By K Positions (Right Rotation)
    // Input : {1, 2, 3, 4, 5, 6, 7}, k = 3
    // Output: {5, 6, 7, 1, 2, 3, 4}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void rotateArrayByK(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 0) return;

        k = k % nums.length;
        reverseSubArray(nums, 0, nums.length - 1);
        reverseSubArray(nums, 0, k - 1);
        reverseSubArray(nums, k, nums.length - 1);
    }

    private static void reverseSubArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp    = nums[start];
            nums[start] = nums[end];
            nums[end]   = temp;
            start++;
            end--;
        }
    }

    // ============================================================================
    // Question: Find Missing Single Number (1 to N sequence)
    // Input : {1, 2, 4, 5, 6}, n = 6
    // Output: 3
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findSingleMissingNumber(int[] arr, int n) {

        int expectedSum = n * (n + 1) / 2;
        int actualSum   = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // ============================================================================
    // Question: Flatten Nested List
    // Input : [[1, 2], [3, 4, 5]]
    // Output: [1, 2, 3, 4, 5]
    // ============================================================================
    public static List<Integer> flattenList(List<List<Integer>> nestedList) {

        if (nestedList == null) return Collections.emptyList();

        return nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Employee Class — used for Stream-based questions below
    // ============================================================================
    public static class Employee {

        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name       = name;
            this.department = department;
            this.salary     = salary;
        }

        public String getName()       { return name; }
        public String getDepartment() { return department; }
        public double getSalary()     { return salary; }

        @Override
        public String toString() {
            return name + " (" + salary + ")";
        }
    }

    // ============================================================================
    // Question: Group Employees By Department (Stream)
    // ============================================================================
    public static Map<String, List<Employee>> groupEmployeesByDept(List<Employee> employees) {

        if (employees == null) return Collections.emptyMap();

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    // ============================================================================
    // Question: Highest Salary Employee By Department (Stream)
    // ============================================================================
    public static Map<String, Optional<Employee>> highestSalaryByDept(List<Employee> employees) {

        if (employees == null) return Collections.emptyMap();

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
    }

    // ============================================================================
    // Question: Employee With Highest Salary
    // ============================================================================
    public static Optional<Employee> highestSalary(List<Employee> employees) {

        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    // ============================================================================
    // Question: Second Highest Salary Employee
    // ============================================================================
    public static Optional<Employee> secondHighestSalary(List<Employee> employees) {

        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
    }

    // ============================================================================
    // Question: Top 3 Highest Paid Employees
    // ============================================================================
    public static List<Employee> top3Employees(List<Employee> employees) {

        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Question: Count Employees In Each Department
    // ============================================================================
    public static Map<String, Long> countByDepartment(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()));
    }

    // ============================================================================
    // Question: Average Salary By Department
    // ============================================================================
    public static Map<String, Double> averageSalaryByDept(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    // ============================================================================
    // Question: Total Salary By Department
    // ============================================================================
    public static Map<String, Double> totalSalaryByDept(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));
    }

    // ============================================================================
    // Question: Employees Earning More Than 50000
    // ============================================================================
    public static List<Employee> highEarners(List<Employee> employees) {

        return employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Question: Sort Employees By Salary Descending
    // ============================================================================
    public static List<Employee> sortBySalaryDesc(List<Employee> employees) {

        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Question: Sort By Department Then Salary
    // ============================================================================
    public static List<Employee> sortDeptSalary(List<Employee> employees) {

        return employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Question: Get Distinct Departments
    // ============================================================================
    public static List<String> departments(List<Employee> employees) {

        return employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Question: Find Employees In IT Department
    // ============================================================================
    public static List<Employee> itEmployees(List<Employee> employees) {

        return employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Question: Group Employee Names By Department
    // ============================================================================
    public static Map<String, List<String>> namesByDept(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
    }

    // ============================================================================
    // Question: Highest Salary Employee Department-Wise
    // ============================================================================
    public static Map<String, Employee> highestSalaryDepartmentWise(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                Optional::get)));
    }

    // ============================================================================
    // Question: Employees Whose Name Starts With "A"
    // ============================================================================
    public static List<Employee> nameStartsWithA(List<Employee> employees) {

        return employees.stream()
                .filter(e -> e.getName().startsWith("A"))
                .collect(Collectors.toList());
    }

    // ============================================================================
    // Question: Highest Paid Employee Name Only
    // ============================================================================
    public static String highestPaidEmployeeName(List<Employee> employees) {

        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName)
                .orElse("");
    }

    // ============================================================================
    // Question: Partition Employees By Salary > 50000
    // ============================================================================
    public static Map<Boolean, List<Employee>> partitionEmployees(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
    }

    // ============================================================================
    // Question: Find Duplicate Employee Names
    // ============================================================================
    public static Set<String> duplicateNames(List<Employee> employees) {

        Set<String> seen = new HashSet<>();

        return employees.stream()
                .map(Employee::getName)
                .filter(name -> !seen.add(name))
                .collect(Collectors.toSet());
    }

    // ============================================================================
    // Question: Find Nth Highest Salary Employee
    // Input : employees list, n = 2
    // Output: Employee with 2nd highest salary
    // ============================================================================
    public static Optional<Employee> nthHighestSalary(List<Employee> employees, int n) {

        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(n - 1)
                .findFirst();
    }

    // ============================================================================
    // Linked List Node (used for Linked List questions)
    // ============================================================================
    public static class ListNode {

        int      val;
        ListNode next;

        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + (next != null ? " -> " + next.toString() : "");
        }
    }

    // ============================================================================
    // Question: Reverse Linked List
    // Input : 1 -> 2 -> 3 -> 4 -> 5
    // Output: 5 -> 4 -> 3 -> 2 -> 1
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static ListNode reverseLinkedList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev      = curr;
            curr      = nextTemp;
        }

        return prev;
    }

    // ============================================================================
    // Question: Remove Nth Node From End Of Linked List
    // Input : 1 -> 2 -> 3 -> 4 -> 5, n = 2
    // Output: 1 -> 2 -> 3 -> 5
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy  = new ListNode(0);
        dummy.next      = head;
        ListNode first  = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first  = first.next;
            second = second.next;
        }

        if (second.next != null) {
            second.next = second.next.next;
        }

        return dummy.next;
    }

    // ============================================================================
    // Question: Find Middle Node Of Linked List
    // Input : 1 -> 2 -> 3 -> 4 -> 5
    // Output: 3
    // Time Complexity : O(n)  (Slow-Fast pointer)
    // Space Complexity: O(1)
    // ============================================================================
    public static ListNode findMiddleNode(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // ============================================================================
    // Question: LRU Cache  (Least Recently Used Cache)
    // Uses LinkedHashMap with access-order = true
    // Automatically evicts the least recently used entry when capacity is exceeded
    // ============================================================================
    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true); // true = access-order
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    // ============================================================================
    // Question: Print Even and Odd Numbers Using Two Threads
    // ============================================================================
    public static void printEvenOddUsingThreads(int max) {

        Object lock     = new Object();
        int[]  counter  = {1};

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (counter[0] <= max) {
                    if (counter[0] % 2 == 0) {
                        try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                    } else {
                        System.out.println("    Odd  Thread : " + counter[0]);
                        counter[0]++;
                        lock.notify();
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (counter[0] <= max) {
                    if (counter[0] % 2 != 0) {
                        try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                    } else {
                        System.out.println("    Even Thread : " + counter[0]);
                        counter[0]++;
                        lock.notify();
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }

    // ============================================================================
    // Question: Producer-Consumer Problem (Using BlockingQueue)
    // ============================================================================
    public static void producerConsumerProblem() {

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("    Produced : " + i);
                    queue.put(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int val = queue.take();
                    System.out.println("    Consumed : " + val);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });

        producer.start();
        consumer.start();
    }

    // ============================================================================
    //                          RUN ALL METHODS
    // ============================================================================
    public static void run() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("            ARRAY CODING QUESTIONS - ALL METHODS            ");
        System.out.println("============================================================");

        int[] arr = {10, 20, 30, 40, 50};

        // ------------------------------------------------------------------
        System.out.println("\n1.  Find Largest Element");
        System.out.println("    Input  : " + Arrays.toString(arr));
        System.out.println("    Output : " + findLargest(arr));

        // ------------------------------------------------------------------
        System.out.println("\n2.  Find Smallest Element");
        System.out.println("    Input  : " + Arrays.toString(arr));
        System.out.println("    Output : " + findSmallest(arr));

        // ------------------------------------------------------------------
        System.out.println("\n3.  Find Second Largest Element");
        System.out.println("    Input  : " + Arrays.toString(arr));
        System.out.println("    Output : " + findSecondLargest(arr));

        // ------------------------------------------------------------------
        System.out.println("\n4.  Find Second Smallest Element");
        System.out.println("    Input  : " + Arrays.toString(arr));
        System.out.println("    Output : " + findSecondSmallest(arr));

        // ------------------------------------------------------------------
        int[] reverseArr = {1, 2, 3, 4, 5};
        reverseArray(reverseArr);
        System.out.println("\n5.  Reverse Array");
        System.out.println("    Input  : [1, 2, 3, 4, 5]");
        System.out.println("    Output : " + Arrays.toString(reverseArr));

        // ------------------------------------------------------------------
        System.out.println("\n6.  Sum Of Array Elements");
        System.out.println("    Input  : " + Arrays.toString(arr));
        System.out.println("    Output : " + sumOfElements(arr));

        // ------------------------------------------------------------------
        System.out.println("\n7.  Average Of Array Elements");
        System.out.println("    Input  : " + Arrays.toString(arr));
        System.out.println("    Output : " + averageOfElements(arr));

        // ------------------------------------------------------------------
        System.out.println("\n8.  Count Even And Odd Numbers");
        System.out.println("    Input  : [1, 2, 3, 4, 5, 6]");
        countEvenOdd(new int[]{1, 2, 3, 4, 5, 6});

        // ------------------------------------------------------------------
        System.out.println("\n9.  Find Maximum And Minimum");
        System.out.println("    Input  : " + Arrays.toString(arr));
        int[] maxMin = findMaxAndMin(arr);
        System.out.println("    Max    : " + maxMin[0]);
        System.out.println("    Min    : " + maxMin[1]);

        // ------------------------------------------------------------------
        System.out.println("\n10. Search Element In Array");
        System.out.println("    Input  : " + Arrays.toString(arr) + ", target = 30");
        System.out.println("    Output : " + searchElement(arr, 30));

        // ------------------------------------------------------------------
        int[] dupArr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println("\n11. Remove Duplicates From Array");
        System.out.println("    Input  : " + Arrays.toString(dupArr));
        System.out.println("    Output : " + Arrays.toString(removeDuplicates(dupArr)));

        // ------------------------------------------------------------------
        System.out.println("\n12. Find Duplicate Elements");
        System.out.println("    Input  : " + Arrays.toString(dupArr));
        System.out.println("    Output : " + findDuplicates(dupArr));

        // ------------------------------------------------------------------
        int[] freqArr = {1, 2, 2, 3, 3, 3};
        System.out.println("\n13. Frequency Of Elements");
        System.out.println("    Input  : " + Arrays.toString(freqArr));
        System.out.println("    Output : " + frequencyCount(freqArr));

        // ------------------------------------------------------------------
        int[] missingArr = {1, 2, 4, 7, 10};
        System.out.println("\n14. Find Missing Numbers In Array");
        System.out.println("    Input  : " + Arrays.toString(missingArr));
        System.out.println("    Output : " + findAllMissingNumbers(missingArr));

        // ------------------------------------------------------------------
        int[] zeros = {0, 1, 0, 3, 12};
        moveZerosToEnd(zeros);
        System.out.println("\n15. Move Zeros To End");
        System.out.println("    Input  : [0, 1, 0, 3, 12]");
        System.out.println("    Output : " + Arrays.toString(zeros));

        // ------------------------------------------------------------------
        int[] leftRotate = {1, 2, 3, 4, 5};
        rotateLeft(leftRotate);
        System.out.println("\n16. Rotate Array Left By One Position");
        System.out.println("    Input  : [1, 2, 3, 4, 5]");
        System.out.println("    Output : " + Arrays.toString(leftRotate));

        // ------------------------------------------------------------------
        int[] rightRotate = {1, 2, 3, 4, 5};
        rotateRight(rightRotate);
        System.out.println("\n17. Rotate Array Right By One Position");
        System.out.println("    Input  : [1, 2, 3, 4, 5]");
        System.out.println("    Output : " + Arrays.toString(rightRotate));

        // ------------------------------------------------------------------
        System.out.println("\n18. Merge Two Arrays");
        System.out.println("    Input  : [1, 2, 3] and [4, 5, 6]");
        System.out.println("    Output : " + Arrays.toString(
                mergeArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6})));

        // ------------------------------------------------------------------
        System.out.println("\n19. Intersection Of Arrays");
        System.out.println("    Input  : [1, 2, 3, 4, 5] and [4, 5, 6, 7]");
        System.out.println("    Output : " + Arrays.toString(
                intersection(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 6, 7})));

        // ------------------------------------------------------------------
        System.out.println("\n20. Union Of Arrays");
        System.out.println("    Input  : [1, 2, 3, 4, 5] and [4, 5, 6, 7]");
        System.out.println("    Output : " + Arrays.toString(
                union(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 6, 7})));

        // ------------------------------------------------------------------
        System.out.println("\n21. Two Sum Problem (Return Indices)");
        System.out.println("    Input  : [2, 7, 11, 15], target = 9");
        List<int[]> twoSumPairs = allPairs(new int[]{2, 7, 11, 15}, 9);
        List<String> twoSumStr = new ArrayList<>();
        for (int[] p : twoSumPairs) twoSumStr.add(Arrays.toString(p));
        System.out.println("    Output : " + twoSumStr + "  (indices)");

        // ------------------------------------------------------------------
        System.out.println("\n22. Pair With Given Sum (Return Values)");
        System.out.println("    Input  : [1, 2, 3, 4, 5], target = 7");
        List<int[]> pairValues = findPairsWithSum(new int[]{1, 2, 3, 4, 5}, 7);
        List<String> pairStr = new ArrayList<>();
        for (int[] p : pairValues) pairStr.add(Arrays.toString(p));
        System.out.println("    Output : " + pairStr);

        // ------------------------------------------------------------------
        System.out.println("\n23. Maximum Subarray Sum (Kadane's Algorithm)");

        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("    Input  : [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        maxSubArray(arr1);
        System.out.println("    (Best subarray = [4, -1, 2, 1])");

        // ------------------------------------------------------------------
        System.out.println("\n24. Leaders In Array");
        System.out.println("    Input  : [16, 17, 4, 3, 5, 2]");
        System.out.println("    Output : " + findLeaders(
                new int[]{16, 17, 4, 3, 5, 2}));

        // ------------------------------------------------------------------
        System.out.println("\n25. Majority Element");
        System.out.println("    Input  : [2, 2, 1, 1, 1, 2, 2]");
        System.out.println("    Output : " + majorityElement(
                new int[]{2, 2, 1, 1, 1, 2, 2}));

        // ------------------------------------------------------------------
        int[] dnf = {2, 0, 2, 1, 1, 0};
        sortZeroOneTwo(dnf);
        System.out.println("\n26. Sort 0s 1s 2s (Dutch National Flag)");
        System.out.println("    Input  : [2, 0, 2, 1, 1, 0]");
        System.out.println("    Output : " + Arrays.toString(dnf));

        // ------------------------------------------------------------------
        System.out.println("\n27. Product Of Array Except Self");
        System.out.println("    Input  : [1, 2, 3, 4]");
        System.out.println("    Output : " + Arrays.toString(
                productExceptSelf(new int[]{1, 2, 3, 4})));

        // ------------------------------------------------------------------
        System.out.println("\n28. Best Time To Buy And Sell Stock");
        System.out.println("    Input  : [7, 1, 5, 3, 6, 4]");
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});

        // ------------------------------------------------------------------
        System.out.println("\n29. First Non-Repeating Element");
        System.out.println("    Input  : [9, 4, 9, 6, 7, 4]");
        System.out.println("    Output : " + firstNonRepeating(
                new int[]{9, 4, 9, 6, 7, 4}));

        // ------------------------------------------------------------------
        System.out.println("\n30. Contains Duplicate");
        System.out.println("    Input  : [1, 2, 3, 1]");
        System.out.println("    Output : " + containsDuplicate(
                new int[]{1, 2, 3, 1}));

        // ------------------------------------------------------------------
        System.out.println("\n31. Sort Array Ascending (Stream)");
        System.out.println("    Input  : [5, 3, 8, 1, 2]");
        System.out.println("    Output : " + Arrays.toString(
                sortAscendingStream(new int[]{5, 3, 8, 1, 2})));

        // ------------------------------------------------------------------
        System.out.println("\n32. Sort Array Descending (Stream)");
        System.out.println("    Input  : [5, 3, 8, 1, 2]");
        System.out.println("    Output : " + Arrays.toString(
                sortDescendingStream(new int[]{5, 3, 8, 1, 2})));

        // ------------------------------------------------------------------
        System.out.println("\n33. Separate Odd and Even Numbers (Stream)");
        System.out.println("    Input  : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        findOddEvenNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        // ------------------------------------------------------------------
        System.out.println("\n34. Next Greater Element");
        System.out.println("    Input  : [4, 5, 2, 10, 8]");
        System.out.println("    Output : " + Arrays.toString(
                nextGreaterElement(new int[]{4, 5, 2, 10, 8})));

        // ------------------------------------------------------------------
        int[] rotateArr = {1, 2, 3, 4, 5, 6, 7};
        rotateArrayByK(rotateArr, 3);
        System.out.println("\n35. Rotate Array By K = 3 (Right Rotation)");
        System.out.println("    Input  : [1, 2, 3, 4, 5, 6, 7]");
        System.out.println("    Output : " + Arrays.toString(rotateArr));

        // ------------------------------------------------------------------
        System.out.println("\n36. Find Missing Single Number (1 to N)");
        System.out.println("    Input  : [1, 2, 4, 5, 6], n = 6");
        System.out.println("    Output : " + findSingleMissingNumber(
                new int[]{1, 2, 4, 5, 6}, 6));

        // ------------------------------------------------------------------
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5));
        System.out.println("\n37. Flatten Nested List");
        System.out.println("    Input  : [[1, 2], [3, 4, 5]]");
        System.out.println("    Output : " + flattenList(nested));

        // ------------------------------------------------------------------
        List<Employee> emps = Arrays.asList(
                new Employee("Alice",   "IT",      70000),
                new Employee("Bob",     "HR",      50000),
                new Employee("Charlie", "IT",      90000),
                new Employee("David",   "Finance", 60000),
                new Employee("Eve",     "HR",      75000)
        );

        System.out.println("\n38. Group Employees By Department");
        System.out.println("    Output : " + groupEmployeesByDept(emps));

        System.out.println("\n39. Highest Salary Employee By Department");
        System.out.println("    Output : " + highestSalaryByDept(emps));

        System.out.println("\n40. Employee With Highest Salary");
        System.out.println("    Output : " + highestSalary(emps).orElse(null));

        System.out.println("\n41. Second Highest Salary Employee");
        System.out.println("    Output : " + secondHighestSalary(emps).orElse(null));

        System.out.println("\n42. Top 3 Highest Paid Employees");
        System.out.println("    Output : " + top3Employees(emps));

        System.out.println("\n43. Count Employees In Each Department");
        System.out.println("    Output : " + countByDepartment(emps));

        System.out.println("\n44. Average Salary By Department");
        System.out.println("    Output : " + averageSalaryByDept(emps));

        System.out.println("\n45. Total Salary By Department");
        System.out.println("    Output : " + totalSalaryByDept(emps));

        System.out.println("\n46. Employees Earning More Than 50000");
        System.out.println("    Output : " + highEarners(emps));

        System.out.println("\n47. Sort Employees By Salary Descending");
        System.out.println("    Output : " + sortBySalaryDesc(emps));

        System.out.println("\n48. Distinct Departments");
        System.out.println("    Output : " + departments(emps));

        System.out.println("\n49. Employees In IT Department");
        System.out.println("    Output : " + itEmployees(emps));

        System.out.println("\n50. Nth Highest Salary (n=2)");
        System.out.println("    Output : " + nthHighestSalary(emps, 2).orElse(null));

        // ------------------------------------------------------------------
        // Linked List examples
        ListNode head = new ListNode(1);
        head.next           = new ListNode(2);
        head.next.next      = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("\n51. Reverse Linked List");
        System.out.println("    Input  : " + head);
        ListNode reversed = reverseLinkedList(head);
        System.out.println("    Output : " + reversed);

        // Rebuild list for next demo
        ListNode head2 = new ListNode(1);
        head2.next           = new ListNode(2);
        head2.next.next      = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.println("\n52. Find Middle Node Of Linked List");
        System.out.println("    Input  : " + head2);
        System.out.println("    Output : " + findMiddleNode(head2).val);

        System.out.println("\n53. Subset Sum Combinations");
        System.out.println("    Input  : nums = [2, 7, 3, 6, 4, 5], target = 9");
        SubsetSum.findCombinations(new int[]{2, 7, 3, 6, 4, 5}, 9);

        System.out.println("\n============================================================");
        System.out.println("                  ALL METHODS EXECUTED !                    ");
        System.out.println("============================================================");
        System.out.println();
    }

}
