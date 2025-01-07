package com.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,5,7,11,15,19,21};
        int key = 22;
        int res = binarySearch(arr,key, 0, arr.length-1);
        if (res == -1)
            System.out.println(key+" is not present");
        else
            System.out.println(key+" is at index: "+res);
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (high >= low){
            int mid = low + (high - low)/2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] > key)
                high = mid-1;
            if (arr[mid] < key)
                low = mid+1;
        }
        return -1;
    }
}
