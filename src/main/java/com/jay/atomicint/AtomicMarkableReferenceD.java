package com.jay.atomicint;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceD {

    public static void main(String[] args) {
        User old = new User("Jane",26);
        AtomicMarkableReference<User> oldAtomicMarkableReference = new AtomicMarkableReference<User>(old,true);
        User newuSER = new User("Jack",28);
        oldAtomicMarkableReference.compareAndSet(old,newuSER,true,true);
        System.out.println(oldAtomicMarkableReference.isMarked());
    }

}
