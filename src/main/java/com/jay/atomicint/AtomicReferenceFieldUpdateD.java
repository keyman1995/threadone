package com.jay.atomicint;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdateD {

    public static void main(String[] args) {

        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(User.class,String.class,"name");//处理姓名

        AtomicIntegerFieldUpdater<User> old = AtomicIntegerFieldUpdater.newUpdater(User.class,"old");//处理年龄

        User user = new User("Jack",25);
        System.out.println("Old User Name"+user.name);
        System.out.println("Old User Year"+user.old);
        updater.compareAndSet(user,user.name,"Mike");
        System.out.println("New User Name"+user.name);
        old.getAndIncrement(user);
        //old.compareAndSet(user,25,28);
        System.out.println("New User old"+user.old);


    }

}
