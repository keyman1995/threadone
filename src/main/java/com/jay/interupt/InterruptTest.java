package com.jay.interupt;

public class InterruptTest {

    private static boolean on = true;

    public static class TestThread implements Runnable{
        public void run() {
            while (on){
                try {
                    System.out.println("can you keep running");
                    synchronized(this) {
                        wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am running");
            }
        }

        public void cancle(){
            on=false;
            System.out.println("I will cancle the Thread.....");

        }


    }

    public static void main(String[] args) throws InterruptedException {
        TestThread t = new TestThread();
        Thread t1 = new Thread(t);
        t1.start();
        Thread.sleep(1000);
        t.cancle();
    }

}
