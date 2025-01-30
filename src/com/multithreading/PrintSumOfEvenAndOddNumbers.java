package com.multithreading;

import java.util.concurrent.*;

public class PrintSumOfEvenAndOddNumbers {
    private static final Object lock = new Object();
    private static int number =1;
    private static final int N = 10;

    static class EvenSum implements Callable<Integer>{
        int evenSum=0;
        @Override
        public Integer call() throws Exception {
            while (number <= N){
                if (number%2 == 0)
                    evenSum+=number++;
            }
            return evenSum;
        }
    }

    static class OddSum implements Callable<Integer>{
        int oddSum =0;
        @Override
        public Integer call() throws Exception {
            while (number <= N){
                if (number%2 != 0)
                    oddSum +=number++;
            }
            return oddSum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> evenSum = executor.submit(new EvenSum());
        Future<Integer> oddSum = executor.submit(new OddSum());
        executor.shutdown();
        System.out.println(evenSum.get()+oddSum.get());
    }


}
