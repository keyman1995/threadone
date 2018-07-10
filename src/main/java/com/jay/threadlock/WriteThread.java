package com.jay.threadlock;

import java.util.concurrent.CountDownLatch;

public class WriteThread extends Thread {

    private ReadAndWriteI readWriteDemo;
    private CountDownLatch countDownLatch;

    public WriteThread(ReadAndWriteI readWriteDemo,CountDownLatch countDownLatch) {
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
        readWriteDemo.writeSome();
        System.out.println("Write 总共花费的时间为"+(System.currentTimeMillis()-start));
    }
}
