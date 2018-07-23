package com.jayreview.blockqueue;

public class TestBlock {

    public static void main(String[] args) {
     BlockQ blockQueue = new BlockQueueCondition(10);
     Thread t1 = new ThreadPush(blockQueue);
     Thread t2 = new ThreadPop(blockQueue);
     t1.start();
     t2.start();

    }

    private static class ThreadPush extends Thread{

        BlockQ<Integer> bq;
        public ThreadPush(BlockQ<Integer> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
           String threadName =Thread.currentThread().getName();
           int i = 20;
           while (i>0){
               try {
                   Thread.sleep(2000);
                   System.out.println("i的值"+i+"will push");
                   bq.enqueue(i--);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    private static class ThreadPop extends Thread{

        private BlockQ<Integer> blockQueue;

        public ThreadPop(BlockQ blockQueue) {
            this.blockQueue = blockQueue;
        }

        @Override
        public void run() {
          while (true){
              System.out.println("PopThread will pop");
              try {
                  Integer i = blockQueue.outqueue();
                  System.out.println("I 的值为"+i);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }
    }


}
