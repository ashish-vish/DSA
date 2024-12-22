package com.sorting;

public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE, min_index = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (a[j] < min) {
                    min = a[j];
                    min_index = j;
                }
            }
            a[min_index] = a[i];
            a[i] = min;
        }
        return a;
    }
}
