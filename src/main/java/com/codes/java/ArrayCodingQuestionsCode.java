package com.codes.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayCodingQuestionsCode {

    // ============================================================================
// Question: Find Largest Element
// Input : {10,20,30,40,50}
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
// Input : {10,20,30,40,50}
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
// Input : {10,20,30,40,50}
// Output: 40
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static int findSecondLargest(int[] arr) {

        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException(
                    "Array must have at least 2 elements");

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > largest) {

                secondLargest = largest;
                largest = num;

            } else if (num > secondLargest
                    && num != largest) {

                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {

            throw new IllegalArgumentException(
                    "No second largest element exists");
        }

        return secondLargest;
    }

    // ============================================================================
// Question: Find Second Smallest Element
// Input : {10,20,30,40,50}
// Output: 20
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static int findSecondSmallest(int[] arr) {

        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException(
                    "Array must have at least 2 elements");

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {

            if (num < smallest) {

                secondSmallest = smallest;
                smallest = num;

            } else if (num < secondSmallest
                    && num != smallest) {

                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {

            throw new IllegalArgumentException(
                    "No second smallest element exists");
        }

        return secondSmallest;
    }

    // ============================================================================
// Question: Reverse Array
// Input : {1,2,3,4,5}
// Output: {5,4,3,2,1}
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static void reverseArray(int[] arr) {

        if (arr == null || arr.length <= 1)
            return;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    // ============================================================================
// Question: Sum Of Array Elements
// Input : {1,2,3,4,5}
// Output: 15
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static int sumOfElements(int[] arr) {

        if (arr == null)
            return 0;

        int sum = 0;

        for (int num : arr) {

            sum += num;
        }

        return sum;
    }

    // ============================================================================
// Question: Average Of Array Elements
// Input : {1,2,3,4,5}
// Output: 3.0
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static double averageOfElements(int[] arr) {

        if (arr == null || arr.length == 0)
            return 0.0;

        return (double) sumOfElements(arr) / arr.length;
    }

    // ============================================================================
// Question: Count Even And Odd Numbers
// Input : {1,2,3,4,5,6}
// Output:
// Even = 3
// Odd = 3
// Time Complexity : O(n)
// ============================================================================
    public static void countEvenOdd(int[] arr) {

        if (arr == null)
            return;

        int even = 0;
        int odd = 0;

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

        System.out.println("Even Count : " + even);
        System.out.println("Odd Count  : " + odd);
    }

    // ============================================================================
// Question: Find Maximum And Minimum
// Input : {10,20,30,40,50}
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

//        int max = Arrays.stream(arr)
//                .max()
//                .orElseThrow();
//
//        int min = Arrays.stream(arr)
//                .min()
//                .orElseThrow();

        return new int[]{max, min};
    }

    // ============================================================================
// Question: Search Element In Array
// Input : {10,20,30,40,50}, 30
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

//        Arrays.stream(arr)
//                .anyMatch(num -> num == target);

        return false;
    }

    // ============================================================================
// Question: Remove Duplicates From Array
// Input : {1,2,2,3,4,4,5}
// Output: {1,2,3,4,5}
// Time Complexity : O(n)
// Space Complexity: O(n)
// ============================================================================
    public static int[] removeDuplicates(int[] arr) {

        if (arr == null)
            return new int[0];

        return Arrays.stream(arr).distinct().toArray();
    }

    // ============================================================================
// Question: Find Duplicate Elements
// Input : {1,2,2,3,4,4,5}
// Output: [2,4]
// Time Complexity : O(n)
// Space Complexity: O(n)
// ============================================================================
    public static Set<Integer> findDuplicates(int[] arr) {

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        if (arr == null)
            return duplicates;

        for (int num : arr) {

            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

//        Arrays.stream(arr)
//                .filter(num -> !seen.add(num))
//                .boxed()
//                .collect(Collectors.toCollection(LinkedHashSet::new));

        return duplicates;
    }

    // ============================================================================
// Question: Frequency Of Elements
// Input : {1,2,2,3,3,3}
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

        return map;
    }

    // ============================================================================
// Question: Missing Number In Array
// Input : {0,1,2,4,5}
// Output: 3
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static List<Integer> findAllMissingNumbers(int[] arr) {

        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0)
            return result;

        int[] copy = Arrays.copyOf(arr, arr.length);

        Arrays.sort(copy);

        for (int i = 0; i < copy.length - 1; i++) {

            for (int num = copy[i] + 1;
                 num < copy[i + 1];
                 num++) {

                result.add(num);
            }
        }

        return result;
    }

    // ============================================================================
// Question: Move Zeros To End
// Input : {0,1,0,3,12}
// Output: {1,3,12,0,0}
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static void moveZerosToEnd(int[] arr) {

        if (arr == null || arr.length <= 1)
            return;

        int insertPos = 0;

        for (int num : arr) {

            if (num != 0) {
                arr[insertPos++] = num;
            }
        }

        while (insertPos < arr.length) {

            arr[insertPos++] = 0;
        }
    }

    // ============================================================================
// Question: Rotate Array Left By One Position
// Input : {1,2,3,4,5}
// Output: {2,3,4,5,1}
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static void rotateLeft(int[] arr) {

        if (arr == null || arr.length <= 1)
            return;

        int first = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {

            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;
    }

    // ============================================================================
// Question: Rotate Array Right By One Position
// Input : {1,2,3,4,5}
// Output: {5,1,2,3,4}
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static void rotateRight(int[] arr) {

        if (arr == null || arr.length <= 1)
            return;

        int last = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {

            arr[i] = arr[i - 1];
        }

        arr[0] = last;
    }

    // ============================================================================
// Question: Merge Two Arrays
// Input : {1,2,3} {4,5,6}
// Output: {1,2,3,4,5,6}
// Time Complexity : O(n+m)
// Space Complexity: O(n+m)
// ============================================================================
    public static int[] mergeArrays(int[] arr1, int[] arr2) {

        return IntStream.concat(
                Arrays.stream(arr1 == null ? new int[0] : arr1),
                Arrays.stream(arr2 == null ? new int[0] : arr2)
        ).toArray();
    }

    // ============================================================================
// Question: Intersection Of Arrays
// Input : {1,2,3,4,5} {4,5,6,7}
// Output: {4,5}
// Time Complexity : O(n+m)
// Space Complexity: O(n)
// ============================================================================
    public static int[] intersection(int[] arr1, int[] arr2) {

        if (arr1 == null || arr2 == null)
            return new int[0];

        Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());

        return Arrays.stream(arr2)
                .distinct()
                .filter(num -> set.contains(num))
                .toArray();
    }

    // ============================================================================
// Question: Union Of Arrays
// Input : {1,2,3,4,5} {4,5,6,7}
// Output: {1,2,3,4,5,6,7}
// Time Complexity : O(n+m)
// Space Complexity: O(n+m)
// ============================================================================
    public static int[] union(int[] arr1, int[] arr2) {

        if (arr1 == null)
            arr1 = new int[0];

        if (arr2 == null)
            arr2 = new int[0];

        return IntStream.concat(
                        Arrays.stream(arr1),
                        Arrays.stream(arr2))
                .distinct()
                .toArray();
    }

    // ============================================================================
// Question: Two Sum Problem
// Input : {2,7,11,15}, target = 9
// Output: [0,1]
// Time Complexity : O(n)
// Space Complexity: O(n)
// ============================================================================
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // ============================================================================
// Question: Pair With Given Sum
// Input : {1,2,3,4,5}, target = 7
// Output: [2,5]
// Time Complexity : O(n)
// Space Complexity: O(n)
// ============================================================================
    public static List<int[]> findPairsWithSum(int[] arr, int target) {

        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        if (arr == null || arr.length < 2)
            return result;

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
// Question: Maximum Subarray Sum (Kadane's Algorithm)
// Input : {-2,1,-3,4,-1,2,1,-5,4}
// Output: 6
// Subarray = {4,-1,2,1}
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static int maxSubArraySum(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            currentSum = Math.max(arr[i],
                    currentSum + arr[i]);

            maxSum = Math.max(maxSum,
                    currentSum);
        }

        return maxSum;
    }

    // ============================================================================
// Question: Leaders In Array
// Input : {16,17,4,3,5,2}
// Output: [17,5,2]
// Time Complexity : O(n)
// Space Complexity: O(n)
// ============================================================================
    public static List<Integer> findLeaders(int[] arr) {

        List<Integer> leaders = new ArrayList<>();

        if (arr == null || arr.length == 0)
            return leaders;

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
// Question: Majority Element
// Input : {2,2,1,1,1,2,2}
// Output: 2
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static Integer majorityElement(int[] nums) {

        if (nums == null || nums.length == 0)
            return null;

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0)
                candidate = num;

            count += (num == candidate) ? 1 : -1;
        }

        count = 0;

        for (int num : nums) {

            if (num == candidate)
                count++;
        }

        return count > nums.length / 2
                ? candidate
                : null;
    }

    // ============================================================================
// Question: Sort 0s 1s 2s
// Input : {2,0,2,1,1,0}
// Output: {0,0,1,1,2,2}
// Dutch National Flag Algorithm
// Time Complexity : O(n)
// Space Complexity: O(1)
// ============================================================================
    public static void sortZeroOneTwo(int[] arr) {

        if (arr == null || arr.length <= 1)
            return;

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            switch (arr[mid]) {

                case 0:

                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;

                    low++;
                    mid++;
                    break;

                case 1:

                    mid++;
                    break;

                case 2:

                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
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
// Input : {1,2,3,4}
// Output: {24,12,8,6}
// Time Complexity : O(n)
// Space Complexity: O(n)
// ============================================================================
    public static int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0)
            return new int[0];

        int n = nums.length;

        int[] result = new int[n];

        result[0] = 1;

        for (int i = 1; i < n; i++) {

            result[i] =
                    result[i - 1] * nums[i - 1];
        }

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] *= right;

            right *= nums[i];
        }

        return result;
    }

    // ============================================================================
// Question: Best Time To Buy And Sell Stock
// Input : {7,1,5,3,6,4}
// Output: 5
// Buy = 1
// Sell = 6
// ============================================================================
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            minPrice = Math.min(minPrice,
                    price);

            maxProfit = Math.max(
                    maxProfit,
                    price - minPrice
            );
        }

        return maxProfit;
    }

    // ============================================================================
// Question: First Non-Repeating Element
// Input : {9,4,9,6,7,4}
// Output: 6
// ============================================================================
    public static Integer firstNonRepeating(int[] arr) {

        if (arr == null || arr.length == 0)
            return null;

        Map<Integer, Integer> map =
                new LinkedHashMap<>();

        for (int num : arr) {

            map.put(num,
                    map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry
                : map.entrySet()) {

            if (entry.getValue() == 1) {

                return entry.getKey();
            }
        }

        return null;
    }

    // ============================================================================
// Question: Contains Duplicate
// Input : {1,2,3,1}
// Output: true
// ============================================================================
    public static boolean containsDuplicate(int[] arr) {

        if (arr == null || arr.length <= 1)
            return false;

        return Arrays.stream(arr).distinct().count() != arr.length;
    }

    public static int[] sortAscendingStream(int[] arr) {

        if (arr == null)
            return null;

        return Arrays.stream(arr).sorted().toArray();
    }

    public static int[] sortDescendingStream(int[] arr) {

        if (arr == null)
            return null;

        return Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void findOddEvenNumbers(int[] nums) {

        if (nums == null)
            return;

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

    public static void run() {
        int[] arr = {10,20,30,40,50};

    System.out.println("1. Largest Element : "
            + findLargest(arr));

    System.out.println("2. Smallest Element : "
            + findSmallest(arr));

    System.out.println("3. Second Largest : "
            + findSecondLargest(arr));

    System.out.println("4. Second Smallest : "
            + findSecondSmallest(arr));

    int[] reverseArr = {1,2,3,4,5};
    reverseArray(reverseArr);
    System.out.println("5. Reverse Array : "
            + Arrays.toString(reverseArr));

    System.out.println("6. Sum Of Elements : "
            + sumOfElements(arr));

    System.out.println("7. Average : "
            + averageOfElements(arr));

    System.out.println("8. Count Even Odd");
    countEvenOdd(new int[]{1,2,3,4,5,6});

    System.out.println("9. Max Min : "
            + Arrays.toString(findMaxAndMin(arr)));

    System.out.println("10. Search 30 : "
            + searchElement(arr, 30));

    System.out.println("11. Remove Duplicates : "
            + Arrays.toString(
            removeDuplicates(new int[]{1,2,2,3,4,4,5})));

    System.out.println("12. Find Duplicates : "
            + findDuplicates(new int[]{1,2,2,3,4,4,5}));

    System.out.println("13. Frequency Count : "
            + frequencyCount(new int[]{1,2,2,3,3,3}));

        System.out.println("14. Missing Numbers : "
                + findAllMissingNumbers(
                new int[]{1,2,4,7,10}));

    int[] zeros = {0,1,0,3,12};
    moveZerosToEnd(zeros);
    System.out.println("15. Move Zeros : "
            + Arrays.toString(zeros));

    int[] leftRotate = {1,2,3,4,5};
    rotateLeft(leftRotate);
    System.out.println("16. Rotate Left : "
            + Arrays.toString(leftRotate));

    int[] rightRotate = {1,2,3,4,5};
    rotateRight(rightRotate);
    System.out.println("17. Rotate Right : "
            + Arrays.toString(rightRotate));

    System.out.println("18. Merge Arrays : "
            + Arrays.toString(
            mergeArrays(
                    new int[]{1,2,3},
                    new int[]{4,5,6}
            )));

    System.out.println("19. Intersection : "
            + Arrays.toString(
            intersection(
                    new int[]{1,2,3,4,5},
                    new int[]{4,5,6,7}
            )));

    System.out.println("20. Union : "
            + Arrays.toString(
            union(
                    new int[]{1,2,3,4,5},
                    new int[]{4,5,6,7}
            )));

    System.out.println("21. Two Sum : "
            + Arrays.toString(
            twoSum(
                    new int[]{2,7,11,15},
                    9)));

    List<int[]> pairs = findPairsWithSum(new int[]{1,2,3,4,5}, 7);
    List<String> pairsStr = new ArrayList<>();
    for (int[] pair : pairs) {
        pairsStr.add(Arrays.toString(pair));
    }
    System.out.println("22. Pair With Sum : " + pairsStr);

    System.out.println("23. Kadane : "
            + maxSubArraySum(
            new int[]{
                    -2,1,-3,4,-1,2,1,-5,4
            }));

    System.out.println("24. Leaders : "
            + findLeaders(
            new int[]{
                    16,17,4,3,5,2
            }));

    System.out.println("25. Majority Element : "
            + majorityElement(
            new int[]{
                    2,2,1,1,1,2,2
            }));

    int[] dnf = {2,0,2,1,1,0};
    sortZeroOneTwo(dnf);
    System.out.println("26. Sort 0 1 2 : "
            + Arrays.toString(dnf));

    System.out.println("27. Product Except Self : "
            + Arrays.toString(
            productExceptSelf(
                    new int[]{1,2,3,4}
            )));

    System.out.println("28. Max Profit : "
            + maxProfit(
            new int[]{
                    7,1,5,3,6,4
            }));

    System.out.println("29. First Non-Repeating : "
            + firstNonRepeating(
            new int[]{
                    9,4,9,6,7,4
            }));

    System.out.println("30. Contains Duplicate : "
            + containsDuplicate(
            new int[]{
                    1,2,3,1
            }));

    System.out.println("31. Sort Ascending Stream : "
            + Arrays.toString(sortAscendingStream(new int[]{5, 3, 8, 1, 2})));

    System.out.println("32. Sort Descending Stream : "
            + Arrays.toString(sortDescendingStream(new int[]{5, 3, 8, 1, 2})));

    System.out.println("33. Find Odd Even Numbers Stream:");
    findOddEvenNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
}

}
