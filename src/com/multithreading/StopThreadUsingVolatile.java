package com.multithreading;

import java.util.concurrent.TimeUnit;

public class StopThreadUsingVolatile {
    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                while (!stop) {
                    System.out.println("in while ..");
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }
}
