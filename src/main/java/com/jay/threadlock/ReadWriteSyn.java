package com.jay.threadlock;

public class ReadWriteSyn implements ReadAndWriteI {


    public synchronized void  readSome() {
        try {
            Thread.sleep(1000);
            System.out.println("I am reading");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeSome() {
        try {
            Thread.sleep(2000);
            System.out.println("I am Writing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
