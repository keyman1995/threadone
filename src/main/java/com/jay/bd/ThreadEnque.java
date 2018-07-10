package com.jay.bd;

public class ThreadEnque extends Thread {

    BlockInter<Integer> bd;

    public ThreadEnque(BlockInter<Integer> bd) {
        this.bd = bd;
    }


    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"will pop");
            try {
                Integer i = bd.dequene();
                System.out.println("i="+i.intValue()+"alread pop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
