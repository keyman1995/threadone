package com.jay.bd;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingCon<T> implements BlockInter<T> {

    Lock lock = new ReentrantLock();
    private Condition needNotEmpty = lock.newCondition();
    private Condition needNotFull =lock.newCondition();


    public void enquene(T item) throws InterruptedException {
        lock.lock();
        try{
            while(this.queue.size()==this.limit){
                needNotFull.await();
            }
            this.queue.add(item);
            needNotEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T dequene() throws InterruptedException {
        lock.lock();
        try {
            while (this.queue.size()==0){
               needNotEmpty.await();
            }
            needNotFull.signal();
        }finally {
            lock.unlock();
        }
        return (T)this.queue.remove(0);
    }
}
