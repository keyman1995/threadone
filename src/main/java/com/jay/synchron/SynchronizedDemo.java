package com.jay.synchron;

public class SynchronizedDemo {


    //类锁
    public static class TestClassSyn extends Thread{

        @Override
        public void run() {
            System.out.println("TestClass is going");
            try {
                synclass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //对象锁
    public static class TestInstanceSyn extends Thread{
        private SynchronizedDemo synchronizedDemo;
        public TestInstanceSyn(SynchronizedDemo synchronizedDemo){
            this.synchronizedDemo = synchronizedDemo;
        }
        @Override
        public void run() {
            System.out.println("TestInstance is going......"+synchronizedDemo);
            try {
                synchronizedDemo.syninstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //测试对象锁2
    public static class TestClassSyn2 extends Thread{

        private SynchronizedDemo synchronizedDemo;

        public TestClassSyn2(SynchronizedDemo synchronizedDemo){
            this.synchronizedDemo = synchronizedDemo;
        }
        @Override
        public void run() {
            System.out.println("TestClassSyn2 is going......"+synchronizedDemo);
            try {
                synchronizedDemo.syninstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //对象锁的方法
    private synchronized void syninstance() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("syninstance is going");
        Thread.sleep(1000);
        System.out.println("syninstance is finished");
    }


    //锁类的方法
    private static synchronized void synclass() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("synclass is going");
        Thread.sleep(1000);
        System.out.println("synclass is finished");
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        Thread t1 = new TestClassSyn();
        Thread t2 =new TestInstanceSyn(synchronizedDemo);
        Thread t3 = new TestClassSyn2(synchronizedDemo);
        t1.start();
        t2.start();
        t3.start();
    }




}
