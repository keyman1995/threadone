package com.jay.container;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ConcurrentHashMapD implements Runnable {

    //JDK 1.7之前的 ConcurrentHashMap h和 JDK1.8
    /**
     * jdk1.7 使用分段锁，将整个
     */

    private int start = 0;

    public ConcurrentHashMapD(int start) {
        this.start = start;
    }

    static Map<String,String> map = new HashMap<String, String>(16);
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    @Override
    public void run() {
        for(int i=0;i<100;i++){
           map.put(String.valueOf(i),String.valueOf(Math.random()*100));
        }
    }

    public static void main(String[] args) {

        Thread[] t =new Thread[100];
        for(int i=0;i<100;i++){
            t[i] = new Thread(new ConcurrentHashMapD(i));
        }
        for(int i=0;i<100;i++){
            t[i].start();
        }

        System.out.println(map.size());
    }



}
