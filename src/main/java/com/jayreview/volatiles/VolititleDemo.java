package com.jayreview.volatiles;

public class VolititleDemo implements Runnable {

    private volatile int i =0;//Volitile 修饰的变量是线程不安全的，多线程在读的过程中他能够保证多个线程拿到的值永远都是最新的

    @Override
    public void run() {
        synchronized (this){
            i = i+1;
            System.out.println(Thread.currentThread().getId()+"I 的值为"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i+1;
            System.out.println(Thread.currentThread().getId()+"I 的值为"+i);
        }
    }

    public static void main(String[] args) {
        VolititleDemo volititleDemo = new VolititleDemo();
        Thread t1 = new Thread(volititleDemo);
        Thread t2 = new Thread(volititleDemo);
        Thread t3 = new Thread(volititleDemo);
        Thread t4 = new Thread(volititleDemo);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
