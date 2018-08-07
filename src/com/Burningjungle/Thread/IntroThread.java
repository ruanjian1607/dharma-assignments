package com.Burningjungle.Thread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.annotation.processing.ProcessingEnvironment;

public class IntroThread extends Thread {
    public IntroThread(String name){
        super(name);
    }
    @Override
    public void run(){
        System.out.println("THREAD START" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            Processing();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("THREAD END" + Thread.currentThread().getName());
    }

    private void Processing() {
        System.out.println("PROCESSING...");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new IntroThread("imthred1");
        Thread t2 = new IntroThread("imthred2");
        t1.start();
        t2.start();
    }
}
