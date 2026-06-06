package com.codes.java.codingquestions.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class OddEvenNumbers {

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

    // Test Cases
    public static void run() {
        System.out.println("\n--- Odd and Even Numbers ---");

        int[][] tests = {
                {1, 2, 3, 4, 5, 6},
                {10, 15, 20, 25, 30},
                {7, 9, 11},
                {2, 4, 6, 8},
                {-1, -2, -3, -4}
        };

        for (int[] test : tests) {
            System.out.println("Input Array: " + Arrays.toString(test));
            findOddEvenNumbers(test);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        run();
    }
}