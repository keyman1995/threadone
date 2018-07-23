package com.jay.threadpool;

public class ThreadTest {


    public static void main(String[] args) throws InterruptedException {

        MyThreadPool myThreadPool = new MyThreadPool(3);
        myThreadPool.execute(new MyThread("test A"));
        myThreadPool.execute(new MyThread("test B"));
        myThreadPool.execute(new MyThread("test C"));
        myThreadPool.execute(new MyThread("test D"));
        myThreadPool.execute(new MyThread("test E"));
        myThreadPool.execute(new MyThread("test F"));
        System.out.println("---------------------"+myThreadPool);
        Thread.sleep(5000);
        myThreadPool.destroyPool();
        System.out.println("++++++++++++++++++++"+myThreadPool);
    }
}
