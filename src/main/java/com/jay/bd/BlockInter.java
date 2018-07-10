package com.jay.bd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface BlockInter<T> {

    List queue = new ArrayList();
    public final Integer limit = 10;


    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();


    void enquene(T item) throws InterruptedException;

    T dequene () throws InterruptedException;



}
