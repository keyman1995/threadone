package com.jayreview.inter;

public class NotifyDemo extends Thread {

    private static int i = 0;

    private static boolean on = true;

    private static Object o = new Object();

    @Override
    public void run() {
        System.out.println("Thread 1"+Thread.currentThread().isInterrupted());
        while (on&& !Thread.currentThread().isInterrupted()){
            System.out.println(i++);
            synchronized (this){
                try {
                    wait();
                } catch (InterruptedException e) {
                    //Thread.currentThread().interrupt();
                    System.out.println("中断异常"+Thread.currentThread().isInterrupted());
                }
            }
        }
        System.out.println("I 的最终值是"+i);
        System.out.println("Thread 2"+Thread.currentThread().isInterrupted());
    }

    public synchronized void cancle(){
      //  on = false;
        //由于cancle 方法的调用是实例了一个 NotifyDemo 对象调用的 在JVM中如果调用了一个类的实例方法，虚拟机会将当前方法
        //加载到当前方法栈帧的顶部去执行
        interrupt();
        System.out.println("执行本方法的线程"+Thread.currentThread().getId());
        System.out.println("本方法所在的实例线程"+getId());
        //Thread.currentThread().interrupt();会把调用线程的方法进行中断
    }

   private static  class TryWhile extends Thread{
        @Override
        public void run() {
            try{
                while (on){
                    System.out.println("当前 I 的值"+i);
                    synchronized (o){
                        o.wait();
                    }
                }
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().getId());
            }
            System.out.println("I 的最终值为："+i);
        }

        public synchronized void cancle(){
            //  on = false;
            //由于cancle 方法的调用是实例了一个 NotifyDemo 对象调用的 在JVM中如果调用了一个类的实例方法，虚拟机会将当前方法
            //加载到当前方法栈帧的顶部去执行
            interrupt();
            System.out.println("执行本方法的线程"+Thread.currentThread().getId());
            System.out.println("本方法所在的实例线程"+getId());
            //Thread.currentThread().interrupt();会把调用线程的方法进行中断
        }

    }



    public static void main(String[] args) throws InterruptedException {
      /*  NotifyDemo notifyDemo = new NotifyDemo();
        notifyDemo.setName("WAITING THREAD");
        notifyDemo.start();
        Thread.sleep(1000);
        notifyDemo.cancle();*/

      TryWhile tryWhile = new TryWhile();
      tryWhile.start();
      Thread.sleep(1000);
      tryWhile.cancle();
    }
}


