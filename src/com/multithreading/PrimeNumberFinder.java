package com.multithreading;
/*
Problem: Create a program where two threads are responsible for finding prime numbers in two halves of an array.
The main method should print out the list of prime numbers found by each thread once both threads have completed.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeNumberFinder {
    private static final Object lock = new Object();
    private static final int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    private static final int mid = arr.length/2;
    private static final int end = arr.length;

    public static boolean isPrime(int number) {
        if (number <= 1) return false; // 0 and 1 are not prime numbers
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false; // Divisible by i, not prime
        }
        return true; // Prime if no divisors found
    }

    static class FirstHalfPrimeNumbers implements Callable<List<Integer>>{
        List<Integer> firstHalfList = new ArrayList<>();
        @Override
        public List<Integer> call() throws Exception {
            int start = 0;
            for (int i = start; i<= mid; i++){
                if (isPrime(arr[i]))
                    firstHalfList.add(arr[i]);
            }
            return firstHalfList;
        }
    }

    static class SecondHalfPrimeNumbers implements Callable<List<Integer>>{
        List<Integer> secondHalfList = new ArrayList<>();
        @Override
        public List<Integer> call() throws Exception {
            for (int i = mid+1; i< end; i++){
                if (isPrime(arr[i]))
                    secondHalfList.add(arr[i]);
            }
            return secondHalfList;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<List<Integer>> firstHalf = executor.submit(new FirstHalfPrimeNumbers());
        Future<List<Integer>> secondHalf = executor.submit(new SecondHalfPrimeNumbers());

        List<Integer> firstHalfInteger = firstHalf.get();
        List<Integer> secondHalfInteger = secondHalf.get();

        for (Integer num : firstHalfInteger)
            System.out.println(num);
        for (Integer num : secondHalfInteger)
            System.out.println(num);

        executor.shutdown();
    }
}
