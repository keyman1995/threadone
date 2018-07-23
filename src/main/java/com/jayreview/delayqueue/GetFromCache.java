package com.jayreview.delayqueue;

import java.util.concurrent.DelayQueue;

public class GetFromCache implements Runnable {

    private DelayQueue<CacheBean<User>> delayQueue;

    public GetFromCache(DelayQueue<CacheBean<User>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                CacheBean<User> item = delayQueue.take();
                System.out.println("GetFromCache 的id"+item.getId()+":"+item.getName()+":Data 中的Name"+item.getData().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
