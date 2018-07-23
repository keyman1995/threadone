package com.jay.threadpool;

import java.util.LinkedList;
import java.util.List;

public class MyThreadPool {

    private int work_num = 5;//默认的线程个数
    private WorkThread[] workThreads;//线程的容器
    private List<Runnable> taskQueue = new LinkedList<Runnable>();//任务队列

    public MyThreadPool(int work_num) {
        this.work_num = work_num;
        workThreads = new WorkThread[work_num];
        for(int i=0;i<work_num;i++){
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    //实际工作的线程
    private class WorkThread extends Thread{

        private  volatile boolean on = true;

        @Override
        public void run() {
            Runnable r = null;
            try {
                while (on &&!isInterrupted()){
                    synchronized (taskQueue){
                        while (on&&!isInterrupted()&&taskQueue.isEmpty()){
                            taskQueue.wait(1000);
                        }
                        if(on&&!isInterrupted()&&!taskQueue.isEmpty()){
                            r = taskQueue.remove(0);
                        }
                    }
                    if(r!=null){
                        System.out.println(getId()+" ready Execute");
                        r.run();
                    }
                    r=null;
                }
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getId()+"is Interrupted");
            }
        }

        //关闭工作线程
        public void stopWorker(){
            on = false;
            interrupt();
        }
    }

    public void destroyPool(){
        for(int i=0;i<work_num;i++){
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        taskQueue.clear();
    }

    public void execute(Runnable task){
        synchronized (taskQueue){
            taskQueue.add(task);
            taskQueue.notify();
        }
    }




}
