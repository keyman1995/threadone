package com.jayreview.delayqueue;

import java.util.concurrent.DelayQueue;

public class PutCache  implements Runnable{

    private DelayQueue<CacheBean<User>> delayQueue;

    public PutCache(DelayQueue<CacheBean<User>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            CacheBean<User> cacheBean = new CacheBean(i+"",i+"秒",new User("ZhangSan"),i*1000);
            System.out.println("put 进去了cacheBean"+cacheBean.getId());
            delayQueue.put(cacheBean);
        }
    }
}
