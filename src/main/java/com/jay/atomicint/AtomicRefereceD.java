package com.jay.atomicint;

import java.util.concurrent.atomic.AtomicReference;

//原子更新引用类型提供的类（AtomicReference）
public class AtomicRefereceD {


    public static void main(String[] args) {

        User user = new User("Jack",25);
        AtomicReference<User> atomicReference = new AtomicReference<User>(user);
        User newUser = new User("Json",25);
        atomicReference.compareAndSet(user,newUser);
        System.out.println(user.getClass());
        System.out.println(atomicReference.get().getClass());
        System.out.println(user.getName());

    }

}

class User{
    public volatile String name;
    public volatile int old;

    public User(String name, Integer old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
