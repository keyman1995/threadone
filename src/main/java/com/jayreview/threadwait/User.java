package com.jayreview.threadwait;

public class User {

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public synchronized void waitAge(){
        while (this.age<31){
            try {
                wait();
                System.out.println("wait age"+Thread.currentThread().getId()+"is notified!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the age is "+this.age);
    }


    public synchronized void waitName(){
        while (this.name.equals("ZhangSan")){
            try {
                wait();
                System.out.println("wait Name"+Thread.currentThread().getId()+"is notified!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the Name is "+this.name);
        }
    }


    public synchronized void changeAge(){
        this.age=31;
        notify();
    }

    public synchronized void changeName(){
        this.name="LiSi";
        notifyAll();
    }




}
