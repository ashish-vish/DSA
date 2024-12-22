package com.sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {5,1,3,2,7,6,3,56};
        System.out.println(Arrays.toString(a));
        Sort sortAlgo = new SelectionSort();
        int[] result = sortAlgo.sort(a);
        System.out.println(Arrays.toString(result));
    }
}
