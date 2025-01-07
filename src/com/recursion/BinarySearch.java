package com.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,5,7,11,15,19,21};
        int key = 21;
        int res = binarySearch(arr,key, 0, arr.length-1);
        System.out.println(key+" is at index: "+res);
    }

    private static int binarySearch(int[] arr, int key,int low, int high) {
        if (high>=low){
            int mid = (low+high)/2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid]>key)
                return  binarySearch(arr,key,low,mid-1);
            if (arr[mid]<key)
                return binarySearch(arr,key,mid+1,high);
        }
        return -1;
    }
}
