package com.arrays;

/*
*
* Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
*
* Its solution is value of  (r-1)C(c-1) (Permutation & combination (nCr) )
*
* Solution1 : We can separately calculate n!, r!, (n-r)! and using their values we can calculate nCr.
*             This is an extremely naive way to calculate. The time complexity will be O(n)+O(r)+O(n-r).
 */

public class PascalTriangleVariation1 {

    public static void main(String[] args) {
        int r = 5;
        int c = 3;

        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r-1,c-1) is: " + element);
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }

    private static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

}
