package com.recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverseArray(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int st, int end) {
        if(st==end)
            return;
        int temp =arr[st];
        arr[st]=arr[end];
        arr[end]=temp;
        reverseArray(arr,st+1,end-1);
    }
}
