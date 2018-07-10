package com.jay.threadlock;


import com.jay.aqs.DLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocker extends Thread {

    private static Lock lock = new ReentrantLock();
    //计数器count是闭锁需要等待的线程数量
    private static CountDownLatch countDownLatch= new CountDownLatch(1);

    public void LockDemon(){
        lock.lock();
        try{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hell I am in The Locker");
        }finally {
            lock.unlock();
        }
    }

    public static void startUp(){
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockDemon();
    }
}
