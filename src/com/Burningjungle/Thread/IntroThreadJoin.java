package com.Burningjungle.Thread;

public class IntroThreadJoin {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new IntroRunnable(), "t1");
        Thread t2 = new Thread(new IntroRunnable(), "t2");
        Thread t3 = new Thread(new IntroRunnable(), "t3");

        t1.start();
        t1.join();

        t2.start();
        t1.join();

        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("all done");

    }
}
