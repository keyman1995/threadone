package com.jay.threadlock;

import java.util.concurrent.CountDownLatch;

public class ReadThread extends Thread {

    private ReadAndWriteI readWriteDemo;
    private  CountDownLatch countDownLatch;

    public ReadThread(ReadAndWriteI readWriteDemo,CountDownLatch countDownLatch) {
        this.readWriteDemo = readWriteDemo;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readWriteDemo.readSome();

        System.out.println("Read 总共花费的时间为"+(System.currentTimeMillis()-start));
    }
}
