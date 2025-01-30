package com.multithreading.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintEvenOdd {
    private static final String s = "abc";
    static int[] arr = {1,2,3,4,5,6,7,8,9,10};


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new PrintEvenNumbers());
        executorService.execute(new PrintOddNumbers());

    }

    static class PrintEvenNumbers implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<arr.length;i++){
                synchronized (s){
                    if (arr[i]%2 == 0){
                        System.out.println("print by: "+ Thread.currentThread().getName()+" -> "+arr[i]);
                        s.notify();
                    }else {
                        try {
                            s.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    static class PrintOddNumbers implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<arr.length;i++){
                synchronized (s){
                    if (arr[i]%2 != 0){
                        System.out.println("print by: "+ Thread.currentThread().getName()+" -> "+arr[i]);
                        s.notify();
                    }else {
                        try {
                            s.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
