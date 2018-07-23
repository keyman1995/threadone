package com.jayreview.blockqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueueCondition<T> implements BlockQ {

    private List queue = new LinkedList();
    private final int limit;
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition notfull = lock.newCondition();
    public BlockQueueCondition(int limit) {
        this.limit = limit;
    }

    @Override
    public void enqueue(Object item) throws InterruptedException {
        lock.lock();
        try{
           while (queue.size()==limit){
             full.await();
           }
            queue.add(item);
            notfull.signal();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public Object outqueue() throws InterruptedException {
        lock.lock();
        try{
            while (queue.size()==0){
                notfull.await();
            }
            full.signal();
            return queue.remove(0);
        }finally {
            lock.unlock();
        }
    }
}
