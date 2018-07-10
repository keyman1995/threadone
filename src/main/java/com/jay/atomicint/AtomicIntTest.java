package com.jay.atomicint;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *原子更新数组类型
 * 原子更新引用类型 AtomicReferece
 *
 */
//原子更新数组 数组通过构造方法传入 类会将数组复制一份原数组不会发生变化
public class AtomicIntTest {

    private static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        //原子递增，返回递增以前的值
        System.out.println(ai.getAndIncrement());
        //原子递增，返回的是递增以后的值
        System.out.println(ai.incrementAndGet());


        System.out.println(ai.get());
    }


}
