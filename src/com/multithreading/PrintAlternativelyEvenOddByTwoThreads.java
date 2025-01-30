package com.multithreading;
/*
Problem: You have two threads: one thread prints even numbers from 1 to N, and another thread prints odd numbers from 1 to N.
Ensure that the output is printed alternately (odd-even-odd-even…). The main method should ensure that the threads print numbers in the correct order.
 */
public class PrintAlternativelyEvenOddByTwoThreads {

    private static final Object lock = new Object();
    private static int number = 1;
    private static int N = 10;

    public static void main(String[] args) {
        PrintEvenNumberTask printEvenNumberTask = new PrintEvenNumberTask();
        PrintOddNumberTask printOddNumberTask = new PrintOddNumberTask();

        Thread t1 = new Thread(printEvenNumberTask);
        Thread t2 = new Thread(printOddNumberTask);

        t1.start();
        t2.start();
    }

    static class PrintEvenNumberTask implements Runnable{
        @Override
        public void run() {
            while (number <= N){
                synchronized (lock){
                    if (number%2 != 0){
                        System.out.print(number + " ");
                        number++;
                        lock.notify();
                    }else {
                        try{
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    static class PrintOddNumberTask implements Runnable{

        @Override
        public void run() {
            while (number <= N){
                synchronized (lock){
                    if (number%2 == 0){
                        System.out.print(number + " ");
                        number++;
                        lock.notify();
                    }else {
                        try{
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

}
