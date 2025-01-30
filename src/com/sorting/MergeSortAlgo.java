package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortAlgo {

    private static void mergeSort(int[] a, int st, int end){
        if (st >= end)
            return;

        int mid = (st+end)/2;
        mergeSort(a,st,mid);
        mergeSort(a,mid+1,end);
        merge(a,st,mid,end);
    }

    private static void merge(int[] a, int st, int mid, int end) {
        List<Integer> tempList = new ArrayList<>();

        int left = st;
        int right = mid+1;

        while (left <= mid && right <= end){
            if (a[left] <= a[right])
                tempList.add(a[left++]);
            else
                tempList.add(a[right++]);
        }
        while (left <= mid){
            tempList.add(a[left++]);
        }
        while (right <= end){
            tempList.add(a[right++]);
        }

        for (int i=st;i<=end;i++){
            a[i]=tempList.get(i-st);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {24,5,1,3,2,7,6,3,56};
        System.out.println(Arrays.toString(a));
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
