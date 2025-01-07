package com.recursion;

public class SumOfnMubers {


    public static void main(String[] args) {
        int sum = sumOfNumbers(10);
        System.out.println(sum);
    }


    public static int sumOfNumbers(int n) {
        if(n<=0)
            return 0;
        return n+sumOfNumbers(n-1);
    }
}
