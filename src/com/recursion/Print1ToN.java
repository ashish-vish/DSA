package com.recursion;

public class Print1ToN {
    public static void main(String[] args) {
        print1ToN(1,10);
    }

    private static void print1ToN(int st, int n) {
        if(st>n)
            return;
        System.out.println(st);
        print1ToN(st+1,n);
    }
}
