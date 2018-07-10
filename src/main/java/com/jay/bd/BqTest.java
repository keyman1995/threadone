package com.jay.bd;

public class BqTest {


    public static void main(String[] args) {

   /*     BlockingQueue bq = new BlockingQueue();
        ThreadPush push = new ThreadPush(bq);
        ThreadEnque te = new ThreadEnque(bq);
        push.start();
        te.start();*/
        BlockInter bq = new BlockingCon();
        ThreadPush push = new ThreadPush(bq);
        ThreadEnque te = new ThreadEnque(bq);
        push.start();
        te.start();
    }

}
