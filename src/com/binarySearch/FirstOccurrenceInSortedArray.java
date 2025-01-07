package com.binarySearch;

/*

 */

public class FirstOccurrenceInSortedArray {
    public static void main(String[] args) {
        int[] a = {15,15,15,15,15,19,21,24,25};
        int key = 15;
        System.out.println(firstOccurrence(a,key));
    }

    public static int firstOccurrence(int[] a, int key) {
        int high = a.length-1;
        int low = 0;
        int res = -1;

        while (low <= high){
            int mid = (low + high)/2;
            if (a[mid]==key){
                res = mid;
                high = mid-1;
            }else if (a[mid] > key)
                high = mid -1;
            else
                low = mid+1;
        }
        return res;
    }
}
