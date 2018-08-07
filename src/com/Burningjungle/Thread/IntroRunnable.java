package com.Burningjungle.Thread;

public class IntroRunnable implements Runnable{

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
            Thread _t1 = new Thread(new IntroRunnable(),"imthread1");
            Thread _t2 = new Thread(new IntroRunnable(),"imthread2");
            _t1.start();
            _t2.start();
        }
    }

