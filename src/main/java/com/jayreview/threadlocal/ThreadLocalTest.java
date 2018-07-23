package com.jayreview.threadlocal;

public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "init";
        }
    };


    private static class Tes1 implements Runnable{

        private int id;

        public Tes1(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId()+"---------start");
            String s = threadLocal.get();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Tes1 t = new Tes1(1);
        Thread thread = new Thread(t);
        thread.start();
    }



}
