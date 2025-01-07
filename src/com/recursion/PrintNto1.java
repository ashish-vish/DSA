package com.recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        printNTo1(10);
    }

    private static void printNTo1(int n) {
        if(n<=0)
            return;
        System.out.println(n);
        printNTo1(n-1);
    }
}
