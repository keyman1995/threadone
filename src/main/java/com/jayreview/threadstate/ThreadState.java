package com.jayreview.threadstate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadState {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new SleepThread(),"SleepThread").start();
        new Thread(new Waiting(),"Waiting").start();
        new Thread(new Block(),"Blocking").start();
        new Thread(new Sync(),"Sync").start();
    }


    static class SleepThread implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("only sleep thread");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                        try {
                            Waiting.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    }

    static class Block implements Runnable{
        @Override
        public void run() {
            synchronized (Block.class){
                while (true){
                    try {
                        System.out.println("Block is locked");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Block is not locked");
                }
            }
        }
    }

    static class Sync implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("Sysn be locked");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("Sysn be unlocked");
                lock.unlock();
            }
        }
    }




}
