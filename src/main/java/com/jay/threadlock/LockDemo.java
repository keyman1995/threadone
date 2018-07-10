package com.jay.threadlock;


import java.util.concurrent.CountDownLatch;

/**
 * Lock 的特点：
 * 1 尝试非阻塞地获取锁
 * 2 获取锁的过程中可以被中断
 * 3 超时获取锁
 */

public class LockDemo {

    /**
     * 锁的重入
     * 递归的时候发生锁的重入
     * 公平锁和非公平锁：先对锁发出请求的一定会先被满足，
     * 非公平锁，凡是不支持这种模式的就是非公平锁。
     * @param args
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {

/*      for(int i=0;i<100;i++){
            Thread thread = new ReadThread(new ReadWriteDemo(),countDownLatch);
            thread.start();
        }
        for(int i=0;i<200;i++){
            Thread thread = new WriteThread(new ReadWriteDemo(),countDownLatch);
            thread.start();
        }*/
/*
        for(int i=0;i<100;i++){
            Thread thread = new ReadThread(new ReadWriteSyn(),countDownLatch);
            thread.start();
        }
        for(int i=0;i<200;i++){
            Thread thread = new WriteThread(new ReadWriteDemo(),countDownLatch);
            thread.start();
        }*/
      /*  countDownLatch.countDown();*/

        //ReentranceLock的实现，
        for(int i=0;i<10;i++){
            Thread thread = new ThreadLocker();
            thread.start();
        }
        ThreadLocker.startUp();
    }
    //ReadAndWriteLock 的实现








}
