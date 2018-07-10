package com.jay.thread;

/**
 * Hello world!
 *
 */
public class App implements Runnable {

    private static  volatile boolean on =true;

    public void run() {
        while (on){
            try {
                Thread.sleep(1000);
                System.out.println("I am running haha");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thead is still Running");
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new App();
        Thread test = new Thread(r);
        test.start();
        Thread.sleep(1000);
        System.out.println("执行cancle");
        App.on=false;
    }
}



