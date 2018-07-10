package com.jay.bd;



/**
 * 等待通知机制
 * 实现有界阻塞
 */
public class BlockingQueue<T> implements BlockInter<T> {

    //入队
    public  synchronized void enquene(T item) throws InterruptedException {
        while(this.queue.size()==this.limit){
            wait();
        }
        if(this.queue.size()==0){
            notifyAll();
        }
        this.queue.add(item);

    }

    //出队
    public synchronized T dequene () throws InterruptedException {
        while (this.queue.size()==this.limit){
            notifyAll();
        }
        if(this.queue.size()==0){
            wait();
        }
        return (T)this.queue.remove(0);
    }

}
