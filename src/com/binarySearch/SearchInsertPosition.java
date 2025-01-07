package com.binarySearch;

/*
Problem Statement: You are given a sorted array arr of distinct values and a target value x. You need to search for the index of
the target value in the array.If the value is present in the array, then return its index. Otherwise, determine the index where
it would be inserted in the array while maintaining the sorted order.

Example 1:
Input Format: arr[] = {1,2,4,7}, x = 6
Result: 3
Explanation: 6 is not present in the array. So, if we will insert 6 in the 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

Example 2:
Input Format: arr[] = {1,2,4,7}, x = 2
Result: 1
Explanation: 2 is present in the array and so we will return its index i.e. 1.
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] a = {3,5,7,9,11,15,19,21,24,25};
        int key = 8;
        System.out.println(findInsertPostion(a,key));
    }

    private static int findInsertPostion(int[] a, int key) {
        int high = a.length-1;
        int low = 0;
        int ans=0;

        if (a[low]>key)
            return 0;
        if (a[high]<key)
            return high+1;

        while (low <= high){
            int mid = (low+high)/2;

            if (a[mid]==key)
                return mid;
            else if (a[mid] <key) {
                ans = mid;
                low=mid+1;
            }else {
                high = mid-1;
            }
        }
        return ans+1;
    }
}
