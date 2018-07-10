package com.jay.atomicint;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArrayDemo {

    public static void main(String[] args) {

        int[] arrays = new int[]{1,2};
        AtomicIntegerArray array = new AtomicIntegerArray(arrays);
        array.set(1,15);
        System.out.println(array.get(1));
        System.out.println(arrays[1]);


    }

}
