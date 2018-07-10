package com.jay.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class DLock implements Lock {


    static class Sync extends AbstractQueuedSynchronizer{
        //尝试去获取独占锁
        @Override
        protected boolean tryAcquire(int arg) {
          if(compareAndSetState(0,1)){//原子操作，多线程去获取锁 所以需要原子锁
              setExclusiveOwnerThread(Thread.currentThread());
              return true;
          }
          return false;
        }


        //独占锁获取
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }
}
