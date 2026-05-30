package com.codes.java.codingquestions.arrays;

import java.util.Arrays;

public class BuyAndSellStock {

    // 1. Optimal Approach (Single Pass)
    // Time: O(N), Space: O(1)
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

    // Test Cases
    public static void run() {
        System.out.println("\n--- Best Time to Buy and Sell Stock ---");

        int[][] tests = {
                {7, 1, 5, 3, 6, 4}, // Buy at 1 (Day 2), Sell at 6 (Day 5) -> Profit: 5
                {7, 6, 4, 3, 1},    // Prices only drop, no profit possible -> Profit: 0
                {2, 4, 1},          // Buy at 2, Sell at 4 -> Profit: 2 (Cannot sell before buying)
                {2},                // Not enough days to buy and sell -> Profit: 0
                {1, 2, 3, 4, 5}     // Buy at 1, Sell at 5 -> Profit: 4
        };

        for (int[] test : tests) {
            System.out.println("Input Prices: " + Arrays.toString(test));
            System.out.println("  Max Profit: " + findMaxProfit(test));
            System.out.println();
        }
    }
}