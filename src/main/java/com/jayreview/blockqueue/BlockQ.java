package com.jayreview.blockqueue;

public interface BlockQ<T>  {

    void enqueue(T item) throws InterruptedException;

    T outqueue() throws InterruptedException;

}
