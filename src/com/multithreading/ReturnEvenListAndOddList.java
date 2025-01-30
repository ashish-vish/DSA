package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ReturnEvenListAndOddList {
    public static void main(String[] args) {
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 20);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<List<Integer>> evenCallable = new EvenNumberTask(number);
        Callable<List<Integer>> oddCallable = new OddNumberTask(number);


        Future<List<Integer>> evenFuture = executor.submit(evenCallable);
        Future<List<Integer>> oddFuture = executor.submit(oddCallable);

        try {
            // Wait for both tasks to complete and get the results
            List<Integer> evenNumbers = evenFuture.get();
            List<Integer> oddNumbers = oddFuture.get();

            // Print the results
            System.out.println("Even numbers: " + evenNumbers);
            System.out.println("Odd numbers: " + oddNumbers);

        } catch (InterruptedException | ExecutionException  e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executor.shutdown();
        }
    }

    static class EvenNumberTask implements Callable<List<Integer>>{
        private final List<Integer> evenList = new ArrayList<>();
        private final List<Integer> list;
        EvenNumberTask(List<Integer> list){
            this.list = list;
        }

        @Override
        public List<Integer> call() throws Exception {
            for (int num : list){
                if (num%2==0)
                    evenList.add(num);
            }
            return evenList;
        }
    }
    static class OddNumberTask implements Callable<List<Integer>>{
        private final List<Integer> oddList = new ArrayList<>();
        private final List<Integer> list;
        OddNumberTask(List<Integer> list){
            this.list = list;
        }

        @Override
        public List<Integer> call() throws Exception {
            for (int num : list){
                if (num%2!=0)
                    oddList.add(num);
            }
            return oddList;
        }
    }
}
