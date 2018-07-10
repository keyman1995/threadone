package com.jay.threadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemo implements ReadAndWriteI {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock  rLock = lock.readLock();
    private final Lock  wlock = lock.writeLock();

    public void readSome(){
        rLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("I am reading");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rLock.unlock();
        }
    }

    public void writeSome(){
        wlock.lock();
        try {
            Thread.sleep(2000);
            System.out.println("I am Writing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            wlock.unlock();
        }
    }



}
