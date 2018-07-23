package com.jayreview.threadwait;

public class WaitThread {

    //wait notify 调用一千 当前线程必须持有锁嗲用了wait notify/notifyAll()释放锁（等待通知机制）
    private static User user = new User(30,"ZhangSan");

    private static class CheckAge extends Thread{
        @Override
        public void run() {
            user.waitAge();
        }
    }

    private static class CheckName extends Thread{
        @Override
        public void run() {
            user.waitName();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){
            new CheckAge().start();
        }
        for(int i=0;i<3;i++){
            new CheckName().start();
        }
        Thread.sleep(3000);
        user.changeName();
    }
}
