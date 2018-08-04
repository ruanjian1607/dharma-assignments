package com.Burningjungle.Thread;

public class BasicDaemonThread {
    public static void main(String[] args) {
        Thread dt = new Thread(new DaemonThread(),"dt");
        dt.setDaemon(true);
        dt.start();

       // Thread.join(30000);
        System.out.println("All done");
    }
}
class DaemonThread implements Runnable{
    @Override
    public void run(){
        while (true){
            //processing();
            System.out.println("daemon thread running...");
        }
    }

    private void processing() {
    }
}
