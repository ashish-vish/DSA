package com.recursion;

public class PowerFunction {
    public static void main(String[] args) {
        double number = 2;
        int power= 10;
        System.out.println(powerFunction(number,power));
    }

    private static double powerFunction(double number, int power) {
        if (power == 1 )
            return number;
        return number*powerFunction(number,power-1);
    }
}
