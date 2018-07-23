package com.jayreview.inter;

public class ReviewInterrrupt implements Runnable {
    //保证内存可见性 volatiles
    private volatile boolean on  = true;

    @Override
    public void run() {
        while(on){
            try {
                System.out.println("I will running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("HEllo I am Running");
        }
    }


    public void cancle(){
        System.out.println("I will cancle the thread");
        on = false;
    }

    public static void main(String[] args) throws InterruptedException {
        ReviewInterrrupt interrrupt = new ReviewInterrrupt();
        Thread t = new Thread(interrrupt);
        t.start();
        Thread.sleep(100);
        interrrupt.cancle();
    }

}
