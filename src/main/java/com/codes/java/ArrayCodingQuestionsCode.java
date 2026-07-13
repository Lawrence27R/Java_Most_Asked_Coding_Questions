package com.codes.java;

import com.codes.java.codingquestions.arrays.MajorityElement;

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

//        long even = Arrays.stream(arr)
//                .filter(num -> num % 2 == 0)
//                .count();
//
//        long odd = Arrays.stream(arr)
//                .filter(num -> num % 2 != 0)
//                .count();

//        Map<Boolean, Long> counts = Arrays.stream(arr)
//                .boxed()
//                .collect(Collectors.partitioningBy(
//                        x -> x % 2 == 0,
//                        Collectors.counting()
//                ));
//
//        long even = counts.get(true);
//        long odd = counts.get(false);

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
            if (num > max)
                max = num;
            if (num < min)
                min = num;
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

        if (arr == null)
            return false;

        for (int num : arr) {
            if (num == target)
                return true;
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

        Set<Integer> set       = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        if (arr == null)
            return duplicates;

        for (int num : arr) {
            if (!set.add(num)) {
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

        if (arr == null)
            return map;

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // First non-repeating element
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                System.out.println("First Non-Repeating Element: " + entry.getKey());
//                break;
//            }
//        }

//        Max Count and Element
//        int maxCount = 0;
//        int maxElement = 0;
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > maxCount) {
//                maxCount = entry.getValue();
//                maxElement = entry.getKey();
//            }
//        }

//        MajorityElement in an Array n/2
//        if (maxCount > arr.length / 2) {
//            System.out.println("Majority Element: " + maxElement);
//        } else {
//            System.out.println("No Majority Element");
//        }

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

        if (arr == null || arr.length == 0) {
            return result;
        }

        Set<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
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

        if (nums == null || nums.length <= 1)
            return;

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
    // Question: Merge Two Arrays
    // Input : {1, 2, 3} and {4, 5, 6}
    // Output: {1, 2, 3, 4, 5, 6}
    // Time Complexity : O(n + m)
    // Space Complexity: O(n + m)
    // ============================================================================
    public static int[] mergeArrays(int[] arr1, int[] arr2) {

//        int[] result = new int[arr1.length + arr2.length];
//
//        for (int i = 0; i < arr1.length; i++) {
//            result[i] = arr1[i];
//        }
//
//        for (int i = 0; i < arr2.length; i++) {
//            result[arr1.length + i] = arr2[i];
//        }
//
//        return result;

        return IntStream.concat(
                Arrays.stream(arr1),
                Arrays.stream(arr2)
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
    // Question: Pair With Given Sum  (Not Needed)
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
//                Forget Prev array start with new array
                currentSum = arr[i];
                tempStart = i;
            } else {
//                Prev array is imp continue
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Max Sum = " + maxSum);

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
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

            if (target < 0)
                return;

            for (int i = start; i < nums.length; i++) {
                current.add(nums[i]);
                backtrack(nums, target - nums[i], i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    // ============================================================================
    // Question: Leaders In Array (Not Necessary)
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
    // Question: Sort 0s 1s 2s  (Dutch National Flag Algorithm)
    // Input : {2, 0, 2, 1, 1, 0}
    // Output: {0, 0, 1, 1, 2, 2}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void sortZeroOneTwo(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int zero = 0;
        int one = 0;
        int two = 0;

        // Count 0s, 1s, and 2s
        for (int num : arr) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else if (num == 2) {
                two++;
            } else {
                throw new IllegalArgumentException(
                        "Array should contain only 0, 1, and 2");
            }
        }

        // Fill the array back
        int index = 0;

        for (int i = 0; i < zero; i++) {
            arr[index++] = 0;
        }

        for (int i = 0; i < one; i++) {
            arr[index++] = 1;
        }

        for (int i = 0; i < two; i++) {
            arr[index++] = 2;
        }

        System.out.println(Arrays.toString(arr));
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

        int totalProduct = 1;

        for (int num : nums) {
            totalProduct *= num;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = totalProduct / nums[i];
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
    // Question: First Non-Repeating Element (Already done above)
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

//        Integer[] arr = {5, 3, 8, 1, 2};
//
//        Arrays.sort(arr, Collections.reverseOrder());
//
//        System.out.println(Arrays.toString(arr));

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
    // Question: Sort Map By Values
    // Input : {A=3, B=1, C=2, D=1}
    // Output: {B=1, D=1, C=2, A=3}
    // ============================================================================
    public static void sortMapByValues(Map<String, Integer> map) {

        if (map == null) return;

        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("    Sorted Map : " + sortedMap);
    }

    // ============================================================================
    // Question: Sort Map By Value Then Key
    // Input : {C=2, A=1, D=2, B=1}
    // Output: {A=1, B=1, C=2, D=2}
    // ============================================================================
    public static void sortMapByValueThenKey(Map<String, Integer> map) {

        if (map == null) return;

        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue()
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("    Sorted Map : " + sortedMap);
    }

    // ============================================================================
    // Question: Next Greater Element (Not to do)
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

        if (nums == null || nums.length == 0 || k < 0)
            return;

        k = k % nums.length;
        reverseSubArray(nums, 0, nums.length - 1);
        reverseSubArray(nums, 0, k - 1);
        reverseSubArray(nums, k, nums.length - 1);
    }

    // ============================================================================
    // Question: Rotate Array By K Positions (Left Rotation)
    // Input : {1, 2, 3, 4, 5, 6, 7}, k = 3
    // Output: {4, 5, 6, 7, 1, 2, 3}
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static void rotateArrayLeftByK(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 0)
            return;

        k = k % nums.length;

        reverseSubArray(nums, 0, k - 1);
        reverseSubArray(nums, k, nums.length - 1);
        reverseSubArray(nums, 0, nums.length - 1);
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
    // Question: Find Maximum Consecutive Occurrence of 1
    // Input : "110111101"
    // Output: 4
    // Time Complexity : O(n)
    // Space Complexity: O(1)
    // ============================================================================
    public static int findMaxConsecutiveOnes(String str) {

        int maxCount = 0;
        int currentCount = 0;

        for (char ch : str.toCharArray()) {

            if (ch == '1') {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
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
    // Question: Split Array into Buckets of Fixed Size
    // Input : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], Bucket Size = 3
    // Output: [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
    // ============================================================================
//    List<int[]> buckets = splitArray(arr, bucketSize);
//
//    for (int[] bucket : buckets) {
//        System.out.println(Arrays.toString(bucket));
//    }
    public static List<int[]> splitArray(int[] arr, int bucketSize) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i += bucketSize) {
            result.add(Arrays.copyOfRange(
                    arr,
                    i,
                    Math.min(i + bucketSize, arr.length)
            ));
        }

        return result;
    }

    // ============================================================================
    // Question: Check Whether a Palindrome Can Be Formed from a String
    // Input : "aabb"
    // Output: true
    //
    // Input : "aabbc"
    // Output: true
    //
    // Input : "abc"
    // Output: false
    // ============================================================================
    public static boolean canFormPalindrome(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;

        for (int count : map.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    // ============================================================================
    // Question: Minimum Size Subarray Sum
    // Input : [2,3,1,2,4,3], Target = 7
    // Output: 2
    // Explanation: The subarray [4,3] has the minimum length (2)
    // ============================================================================
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // ============================================================================
    // Question: Find Kth Largest Element
    // Input : [3,2,1,5,6,4], k = 2
    // Output: 5
    // ============================================================================
    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    // ============================================================================
    // Question: Factorial
    // Input : 5
    // Output: 120
    // ============================================================================
    public static long factorial(int n) {

        if (n < 0)
            throw new IllegalArgumentException("Negative numbers not allowed");

        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // ============================================================================
    // Question: Prime Number
    // Input : 29
    // Output: true
    // ============================================================================
    public static boolean isPrime(int n) {

        if (n <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    // ============================================================================
    // Question: Print Fibonacci Series
    // Input : 10
    // Output: 0 1 1 2 3 5 8 13 21 34
    // ============================================================================
    public static void printFibonacciSeries(int n) {

        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {

            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
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

//        System.out.println("\n40. Employee With Highest Salary");
//        System.out.println("    Output : " + highestSalary(emps).orElse(null));
//
//        System.out.println("\n41. Second Highest Salary Employee");
//        System.out.println("    Output : " + secondHighestSalary(emps).orElse(null));

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

        System.out.println("\n53. Subset Sum Combinations");
        System.out.println("    Input  : nums = [2, 7, 3, 6, 4, 5], target = 9");
        SubsetSum.findCombinations(new int[]{2, 7, 3, 6, 4, 5}, 9);

        System.out.println("\n============================================================");
        System.out.println("                  ALL METHODS EXECUTED !                    ");
        System.out.println("============================================================");
        System.out.println();
    }

}
