package com.arrays;

/*
Problem Statement: Given an array of integers arr[] and an integer target.

1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3,
       then nums[1] + nums[1] = target is not a solution.

ARRAYS ARE NOT SORTED
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 100;
        int[] ans = twoSum(n, arr, target);
        System.out.println("This is the answer: [" + ans[0] + ", "
                + ans[1] + "]");
    }

    private static int[] twoSum(int n, int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = {-1,-1};
        for (int i=0;i<n;i++){
            int num = arr[i];
            int moreNeeded = target-num;
            if (map.containsKey(moreNeeded)){
                res[0] = map.get(moreNeeded);
                res[1] = i;
            }
            map.put(arr[i],i);
        }
        for (Map.Entry<Integer,Integer> entrySet : map.entrySet()){
            System.out.println(entrySet.getKey() + ": "+ entrySet.getValue());
        }
        return res;
    }
}
