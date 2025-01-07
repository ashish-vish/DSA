package com.recursion;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(0);
        System.out.println(1);
        printFibonacci(10-2,0,1);
    }

    private static void printFibonacci(int n, int first,int second) {

        if (n<=0)
            return;
        System.out.println(first+second);
        printFibonacci(n-1,second,second+first);
    }
}
