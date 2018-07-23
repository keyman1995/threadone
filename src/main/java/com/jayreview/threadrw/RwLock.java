package com.jayreview.threadrw;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RwLock implements GoodsVo {

    private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final  Lock r = rwlock.readLock();
    private final  Lock w = rwlock.writeLock();

    @Override
    public void readVo() {
       r.lock();
       try{
           try {
               Thread.sleep(5);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }finally {
           r.unlock();
       }

    }

    @Override
    public void writeVo() {
        w.lock();
        try{
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            w.unlock();
        }

    }
}
