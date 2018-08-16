package com.Burningjungle.Thread;

public class AccountingSync implements Runnable{
    static int i = 0;

    public static synchronized void increase (){
        i++;
    }

    @Override
    public void run(){
        for (int i = 0;i < 10000000;i ++){
            increase();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingSync());
        Thread t2 = new Thread(new AccountingSync());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}
