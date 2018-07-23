package com.jayreview.connection;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolTest {

    static ConnectionPool pool = new ConnectionPool(20);
    static CountDownLatch start = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 500;
        end = new CountDownLatch(threadCount);
        int count = 1;//每个线程循环10次
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for(int i=0;i<threadCount;i++){
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionThread-----"+i);
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total try Connection"+(threadCount*count));
        System.out.println("got Connection"+got);
        System.out.println("notGot Connection"+notGot);

    }

    static CountDownLatch end;

    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count>0){
                //从连接池中获取连接，如果1000ms内无法获取到 将会返回null
                try {
                    long mills = 1000;
                    Connection connection = pool.fetchConnetion(1000);
                    if(connection!=null){
                        try {
                            System.out.println(Thread.currentThread().getName()+"*********拿到了线程"+System.currentTimeMillis());
                            long start = System.currentTimeMillis();
                            connection.createStatement();
                            connection.commit();
                            System.out.println(Thread.currentThread().getName()+"执行花费的时间-------------"+(System.currentTimeMillis()-start)+"ms --------------");
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        System.out.println(Thread.currentThread().getName()+"获得失败==============="+System.currentTimeMillis());
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }


}
