package com.jay.bd;

public class ThreadPush extends Thread {

    BlockInter<Integer> bd;

    public ThreadPush(BlockInter<Integer> bd) {
        this.bd = bd;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int i = 20;
        while (i>0){
                try {
                    Thread.sleep(1000);
                    System.out.println("  i= "+i+"will push");
                    bd.enquene(i--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }

    }
}
