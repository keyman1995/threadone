package com.jayreview.classsyn;

public class ClassSynD {

    public  void test1() {
        synchronized (ClassSynD.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {

                }
            }
        }
    }

    public synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
       ClassSynD synD = new ClassSynD();
       ClassSynD synD1 = new ClassSynD();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
             synD.test1();
            }
        },"test1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synD1.test1();
            }
        },"test2");

        t1.start();
        t2.start();
    }
}
