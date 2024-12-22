package com.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxTotal {
    public static void main(String[] args) {
        int[] coins = {1, 2, 1, 4,6,3, 3,4,6,6,2,1};
        int result = maxTotal(coins);
        System.out.println("Maximum total value of coins you can collect: " + result);
    }

    public static int maxTotal(int[] coins) {
        // Sorting the coins array
        Arrays.sort(coins);

        // Creating a frequency map to count occurrences of each value
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int coin : coins) {
            frequencyMap.put(coin, frequencyMap.getOrDefault(coin, 0) + 1);
        }

        // Initializing dp array to store maximum total value for each value
        int[] dp = new int[100001];

        // Base cases
        dp[0] = 0;
        dp[1] = frequencyMap.containsKey(1) ? frequencyMap.get(1) : 0;

        // Iterating through all possible values to fill the dp array
        for (int i = 2; i <= 100000; i++) {
            int frequency = frequencyMap.containsKey(i) ? frequencyMap.get(i) : 0;
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + frequency * i);
        }

        // Returning the maximum total value
        return dp[100000];
    }
}
