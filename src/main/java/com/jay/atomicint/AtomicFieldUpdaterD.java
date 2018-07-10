package com.jay.atomicint;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicFieldUpdaterD {

    /**
     * 更新对象中的某个字段可以使用AtomicStampedReference
     */
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(0,0);

    public static void main(String[] args) throws InterruptedException {
        final int stamp = atomicStampedReference.getStamp();//版本的概念
        final int referece = atomicStampedReference.getReference();//值
        System.out.println(stamp+"==================="+referece);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                final int referece = atomicStampedReference.getReference();
                final int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getId()+":"+referece+"-------"+stamp+atomicStampedReference.compareAndSet(referece,referece+10,stamp,stamp+1));
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                final int referece = atomicStampedReference.getReference();
                final int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getId()+":"+referece+"-------"+stamp+atomicStampedReference.compareAndSet(referece,referece+10,stamp,stamp+1));
            }
        });
        t1.start();
        //t1.join();
        t2.start();
        //t2.join();
        System.out.println(atomicStampedReference.getReference());
        System.out.println(atomicStampedReference.getStamp());
    }

}
