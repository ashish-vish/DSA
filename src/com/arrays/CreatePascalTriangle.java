package com.arrays;

import java.util.Arrays;

public class CreatePascalTriangle {
    public static void main(String[] args) {

        int n = 7;
        int[][] a = new int[n][n];

        for (int i=0;i<n;i++){
            a[i][0]= 1;
        }
        System.out.println(Arrays.deepToString(a));
        for (int i=1;i<n;i++){
            for (int j=1; j<n; j++){
                a[i][j] = a[i-1][j-1]+a[i-1][j];
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
