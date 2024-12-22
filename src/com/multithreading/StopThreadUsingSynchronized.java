package com.multithreading;

import java.util.concurrent.TimeUnit;

public class StopThreadUsingSynchronized {
    private static boolean stop;

    private static synchronized void requestStop() {
        stop = true;
    }

    private static synchronized boolean stop() {
        return stop;
    }

    public static void main(String[] args) throws InterruptedException {
        final int[] count = {0};
        new Thread(new Runnable(){
            public void run(){
                while (!stop()){
                    System.out.println("in while ..."+ count[0]++);
                }
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(100);
        requestStop();
    }

}
