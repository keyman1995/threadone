package com.jay.threadpool;

import java.util.concurrent.*;

public class JdkThreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        ExecutorService pool = Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(5);
        Executors.newWorkStealingPool(5);

        for(int i=0;i<6;i++){
            MyThread thread = new MyThread("任务---"+i);
            System.out.println("task will add"+i);
            /**
             * execute 提交不需要返回值的任务
             * submit 提交需要返回值的任务，返回值是一个future类型的对象，调用future的get方法来获取返回值。
             */
            threadPoolExecutor.execute(thread);
            //threadPoolExecutor.submit(thread);
        }
        /**
         * 关闭线程池
         * Shutdown()遍历每个线程 调用 interrupt 方法来中止限制
         * shutdownNow()尝试种植所有正在执行的线程
         */
        System.out.println(Runtime.getRuntime().availableProcessors());//当前机器中的cpu核心个数

        threadPoolExecutor.shutdown();
    }
}
