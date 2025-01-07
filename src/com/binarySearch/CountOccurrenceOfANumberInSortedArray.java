package com.binarySearch;

/*
Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.


Example 1:
Input:
 N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
Output
: 4
Explanation:
 3 is occurring 4 times in
the given array so it is our answer.

Example 2:
Input:
 N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
Output
: 5
Explanation:
 2 is occurring 5 times in the given array so it is our answer.
 */

public class CountOccurrenceOfANumberInSortedArray {
    public static void main(String[] args) {
        int[] a =  {2, 4, 6, 8, 8, 8, 11, 13};
        int key =8;
        System.out.println(countOccurrence(a,key));
    }

    private static int countOccurrence(int[] a, int key) {
        int lastOccurrence = LastOccurrence.lastOccurrence(a, key);
        int firstOccurrence = FirstOccurrenceInSortedArray.firstOccurrence(a, key);
        return lastOccurrence-firstOccurrence+1;
    }
}
