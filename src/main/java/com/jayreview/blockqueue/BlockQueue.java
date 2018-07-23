package com.jayreview.blockqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * 有界阻塞队列
 * @param <T>
 */
public class BlockQueue<T> implements BlockQ<T>{

    private List list = new LinkedList();
    private final int limit;

    public BlockQueue(int limit) {
        this.limit = limit;
    }
    //入队
    @Override
    public synchronized void enqueue(T item) throws InterruptedException {
        System.out.println("当前list的si+++++++++++++++++++ze"+this.list.size());
        while (this.list.size()==this.limit){
            wait();
            System.out.println("当前list的size"+this.list.size());
        }
        if(this.list.size()==0){
            notifyAll();
        }
        this.list.add(item);
    }

    //出对
    @Override
    public synchronized T outqueue() throws InterruptedException {
        while (this.list.size()==0){
            wait();
            System.out.println("当前list的size-------------"+this.list.size());
        }
        if(this.list.size()==this.limit){
            System.out.println("当前list的size+===================="+this.list.size());
            notifyAll();
        }
       return (T)this.list.remove(0);
    }

}
