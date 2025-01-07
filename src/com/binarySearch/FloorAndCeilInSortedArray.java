package com.binarySearch;

/*
Problem Statement: You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
The floor of x is the largest element in the array which is smaller than or equal to x.
The ceiling of x is the smallest element in the array greater than or equal to x.


Example 1:
Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
Result: 4 7
Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Example 2:
Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8
Result: 8 8
Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
 */

public class FloorAndCeilInSortedArray {

    public static void main(String[] args) {
        int[] a = {3,5,7,9,11,15,19,21,24,25};
        int key = 2;
        floorAndCeilOfAnArray(a, key);
    }

    private static void floorAndCeilOfAnArray(int[] a, int key) {
        int low = 0;
        int high = a.length-1;
        int floor = a[low];
        int ceil = a[high];
        int florrIndex =0;

        while (low <= high){
            int mid = (low + high) / 2;

            if (a[mid] == key){
                floor = ceil = a[mid];
                break;
            }
            else if (a[mid]<key){
                florrIndex=mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        if (floor != ceil){
            floor = a[florrIndex];
            ceil = a[florrIndex+1];
        }
        System.out.println(floor);
        System.out.println(ceil);
    }
}
