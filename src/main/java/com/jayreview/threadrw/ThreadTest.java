package com.jayreview.threadrw;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {


    private  static  CountDownLatch countDownLatch = new CountDownLatch(1);

    private final static int threadCount = 30;


    public static void main(String[] args) {
        GoodsVo goodsVo = new SingleLock();
       // GoodsVo goodsVo = new RwLock();
        for(int i=0;i<threadCount;i++){
            ReadThread r = new ReadThread(goodsVo);
            Thread t = new Thread(r);
            t.start();
        }

        for(int i=0;i<3;i++){
            WriteThread w = new WriteThread(goodsVo);
            Thread t1 = new Thread(w);
            t1.start();
        }
        countDownLatch.countDown();

    }


    private static class ReadThread implements Runnable{

        private GoodsVo goodsVo;

        public ReadThread(GoodsVo goodsVo) {
            this.goodsVo = goodsVo;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long start =  System.currentTimeMillis();
            for(int i=0;i<100;i++){
                goodsVo.readVo();
            }
            long duration = System.currentTimeMillis()-start;
            System.out.println(Thread.currentThread().getId()+"读取数据库共耗时"+duration+"ms");

        }
    }


    private static class WriteThread extends Thread{

        private GoodsVo goodsVo;

        public WriteThread(GoodsVo goodsVo) {
            this.goodsVo = goodsVo;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long start =  System.currentTimeMillis();
            for(int i=0;i<100;i++){
                goodsVo.writeVo();
            }
            long duration = System.currentTimeMillis()-start;
            System.out.println(Thread.currentThread().getId()+"写入数据库共耗时"+duration+"ms");
        }
    }

}
