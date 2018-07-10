package com.jay.aqs;

import java.util.concurrent.locks.Lock;

public class TestLock  {

    public void test() throws InterruptedException {
        final  Lock lock = new TwoLock();

        class Work extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try{
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }  finally{
                        lock.unlock();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for(int i=0;i<10;i++){
            Work work = new Work();
            work.setDaemon(true);
            work.start();
        }

        // 主线程每隔1秒换行
        for (int i = 0; i < 10; i++) {
           Thread.sleep(1000);
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestLock testLock = new TestLock();
        testLock.test();
    }
}
