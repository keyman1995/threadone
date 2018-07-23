package com.jayreview.threadsleep;

public class ThreadSleep {

    //sleep 不会释放锁
    //yield 会让当前线程让出cpu的占有权，当前线程编程可运行状态，下一时刻可能被cpu选中 也不会释放锁
    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {

        new SleepThread().start();
        Thread.sleep(1000);
        new NotSleepThread().start();

    }


    static class SleepThread extends Thread{
        @Override
        public void run() {
            System.out.println("SleepThread will take the lcok");
            try {
                synchronized (ThreadSleep.class){
                    System.out.println("SleepThread get the lock");
                    Thread.sleep(5000);
                    System.out.println("Sleep put the lock");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class NotSleepThread extends Thread{
        @Override
        public void run() {
            System.out.println("NotSleepThead will take the lock");
            synchronized (ThreadSleep.class){
                System.out.println("NotSleepThread get the lock");
                System.out.println("NotSleepThread put the lock");
            }
        }
    }



}
