package com.arrays;

import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args) {
        int[][] a = {{4,1,2,1},{3,4,5,0},{1,3,1,5}};
        int[] row = new int[a.length];
        int[] column = new int[a[0].length];
        int n= a.length;
        int m = a[0].length;
        System.out.println(Arrays.deepToString(a));

//        setMatrixZeroUsingRowAndColumnArray(n, row, m, column, a);
        setMatrixZeroWithoutExtraSpace(n, row, m, column, a);
    }

    private static void setMatrixZeroWithoutExtraSpace(int n, int[] row, int m, int[] column, int[][] a){
        int columnFlag = 1;
        for (int i=0; i<n;i++){
            for (int j=0; j<m; j++){

                if (a[i][j] == 0){
                    a[i][0]=0;
                    if (i != 0)
                        a[0][j] = 0;
                    else
                        columnFlag=0;
                }
            }
        }
        System.out.println(Arrays.deepToString(a));
        System.out.println("columnFlag: "+columnFlag);
    }

    private static void setMatrixZeroUsingRowAndColumnArray(int n, int[] row, int m, int[] column, int[][] a) {
        for (int i = 0; i< n; i++)
            row[i] = 1;
        for (int j = 0; j< m; j++)
            column[j] = 1;

        for (int i = 0; i< n; i++){
            for (int j = 0; j< m; j++){
                if (a[i][j] == 0){
                    row[i] = 0;
                    column[j] = 0;
                }
            }
        }

        for (int i = 0; i< n; i++){
            for (int j = 0; j< m; j++){
                if (row[i] == 0 || column[j] == 0 )
                    a[i][j] = 0;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
