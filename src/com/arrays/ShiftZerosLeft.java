package com.arrays;

import java.util.Arrays;

public class ShiftZerosLeft {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        int n = arr.length;
        int p1=0;
        int p2=0;
        while (p1<n-1){
            while (p1<n-1 && arr[p1] != 0 ){
                p1++;
            }
            p2 = p1+1;
            while (p2 < n-1 && arr[p2] == 0)
                p2++;
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
