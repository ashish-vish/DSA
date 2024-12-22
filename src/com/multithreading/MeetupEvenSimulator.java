package com.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MeetupEvenSimulator {

    public static class MeetupEvent{
        private String name;
        private AtomicInteger count = new AtomicInteger(1); // ATLEAST 1

        public MeetupEvent(String name){
            this.name = name;
        }
        public void attending(int guestCount){
            if (guestCount == 1)
                count.incrementAndGet();
            else
                count.addAndGet(guestCount);
        }

        public void notAttending(int guestCount){
            if (guestCount == 1)
                count.decrementAndGet();
            else {
                boolean updated =false;
                while (!updated){
                    int currentCount = count.get();
                    int newCount = currentCount - guestCount;
                    updated = count.compareAndSet(currentCount, newCount);
                }
            }
        }

        public int getCount(){
            return count.get();
        }
    }

    public static void main(String[] args) {
        MeetupEvent jugBoston = new MeetupEvent("The Boston java user group");

        Thread user1 = new Thread(new Runnable() {
            public void run() {
                jugBoston.attending(4);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
            }
        });

        Thread user2 = new Thread(new Runnable() {
            public void run() {
                jugBoston.attending(1);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
                jugBoston.notAttending(3);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
            }
        });
        Thread user3 = new Thread(new Runnable() {
            public void run() {
                jugBoston.attending(1);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
            }
        });

        user1.setName("User 1");
        user2.setName("User 2");
        user3.setName("User 3");

        user1.start();
        sleep(1);
        user2.start();
        sleep(2);
        user3.start();
        sleep(2);
        System.out.println("Total attending: "+ jugBoston.getCount());
    }

    private static void sleep(int seconds) {
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
