package com.binarySearch;
/*
Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k.
Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.

Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
Result: 4
Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2:
Input Format: arr = [4,5,6,7,0,1,2], k = 3
Result: -1
Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.
 */

public class SearchElementInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a = {7,8,9,0,1,2,4,5,6};
        int key = 111;


        System.out.println(searchInSortedRotatedArray(a,key));
    }

    private static int searchInSortedRotatedArray(int[] a, int key) {
        int low = 0;
        int high = a.length-1;

        while (low<=high){
            int mid = (low+high)/2;
            if (a[mid]==key)
                return mid;

            if (a[low] <= a[mid]){
                if (a[low] <= key && key <= a[mid])
                    high = mid-1;
                else
                    low = mid +1;
            }else {
                if (a[mid] <= key && key <= a[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

}
