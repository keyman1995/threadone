package com.jayreview.delayqueue;

import java.util.concurrent.DelayQueue;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<CacheBean<User>> queue = new DelayQueue<>();
        new Thread(new PutCache(queue)).start();
        new Thread(new GetFromCache(queue)).start();
        for(int i=0;i<20;i++){
            Thread.sleep(500);
            System.out.println(i*500);
        }
    }

}
