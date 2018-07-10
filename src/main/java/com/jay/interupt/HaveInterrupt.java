package com.jay.interupt;

/**
 * synchron 终端线程线程存在的问题
 */
public class HaveInterrupt {

    private static class WhileTry extends Thread{

        private volatile boolean on = true;
        private int i=0;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                try {
                    i++;
                    System.out.println("i的值"+i+Thread.currentThread().isInterrupted());
                    synchronized (this){
                        wait();
                        //抛出终端异常的异常方法，抛出异常后 中断标识为会改成false
                        //可以理解为这些方法会隐含调用Thread.interrupterd()方法；

                    }

                } catch (InterruptedException e) {
                    Thread.interrupted();
                    Thread.currentThread().interrupt();
                    System.out.println("当前本中端的线程标志位："+Thread.currentThread().getId()+":"+Thread.currentThread().isInterrupted());
                    System.out.println("被中断的线程----------"+getId()+":"+isInterrupted());
                }
                System.out.println("Can I running");
            }
            System.out.println("I am stop");

        }

        public void cancle(){
            //on =false;
            interrupt();
        }
    }

    public static class TryWhile extends Thread{//表示只要抛出终端异常时，方法就已经结束了
        private volatile boolean on = true;
        private int i=0;
        @Override
        public void run() {
            try{
                System.out.println();
                while (on){
                    i++;
                    System.out.println("i的值"+i+Thread.currentThread().isInterrupted());
                    synchronized (this){
                        wait();//等待的过程中回去检查中断标识为的状态，如果为true的时候抛出异常。将终端表示为改为false
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public void cancle(){
            interrupt();
        }


    }






    public static void main(String[] args) throws InterruptedException {
 /*       WhileTry whileTry = new WhileTry();
        whileTry.start();
        Thread.sleep(3000);
        whileTry.cancle();*/


        TryWhile tryWhile = new TryWhile();
        tryWhile.start();
        Thread.sleep(3000);
        tryWhile.cancle();

    }


}
