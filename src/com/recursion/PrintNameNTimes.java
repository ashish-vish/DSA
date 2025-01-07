package com.recursion;

public class PrintNameNTimes {
    public static void main(String[] args) {
        printNameNTimes(2);
    }

    static void printNameNTimes(int n){
        if(n<=0)
            return;
        System.out.println("Ashish");
        printNameNTimes(n-1);
    }
}
