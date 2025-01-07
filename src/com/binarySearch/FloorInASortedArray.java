package com.binarySearch;

/*
Input: arr[] = [1, 2, 8, 10, 11, 12, 19], k = 0
Output: -1
Explanation: No element less than 0 is found. So output is -1.

Input: arr[] = [1, 2, 8, 10, 11, 12, 19], k = 5
Output: 1
Explanation: Largest Number less than 5 is 2 , whose index is 1.

Given a sorted array arr[] (with unique elements) and an integer k, find the index (0-based) of the largest element in arr[]
that is less than or equal to k. This element is called the "floor" of k. If such an element does not exist, return -1.
 */

public class FloorInASortedArray {
    public static void main(String[] args) {
        int[] a = {3,5,7,9,11,15,19,21,24,25};
        int key = 2;
        System.out.println(findFloor(a,key));
    }

    private static int findFloor(int[] a,int key) {
        int high = a.length-1;
        int low = 0;
        int ans=-1;

        if (a[0]>key)
            return ans;

        while (low<=high){
            int mid = (low+high)/2;
            if (a[mid] <= key){
                ans = mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return ans;
    }
}
