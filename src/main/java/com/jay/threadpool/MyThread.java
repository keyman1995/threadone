package com.jay.threadpool;

class MyThread implements Runnable{

   private String name;

   public MyThread(String name) {
       this.name = name;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   @Override
   public void run() {
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           System.out.println(Thread.currentThread().getId()+"sleep InterruptedException");
       }
       System.out.println(Thread.currentThread().getId()+"任务"+name+"完成");
   }
}
