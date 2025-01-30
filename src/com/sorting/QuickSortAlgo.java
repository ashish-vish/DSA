package com.sorting;

import java.util.Arrays;

public class QuickSortAlgo {

    public static void quickSort(int[] a, int low, int high){
        if (low >= high)
            return;
        int pIndex = partition(a, low, high);
        quickSort(a,low,pIndex-1);
        quickSort(a,pIndex+1,high);
    }

    private static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int pivot = a[low];

        while (i<j){

            while (a[i]<=pivot && i<=high-1)
                i++;
            while (a[j]>=pivot && j>=low+1)
                j--;

            if (i<j)
                swap(a,i,j);
        }
        swap(a,low,j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[] {24,5,1,3,2,7,6,3,56};
        System.out.println(Arrays.toString(a));
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
