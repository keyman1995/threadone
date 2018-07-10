package com.jay.waitandnotify;

public class User {

    private String city;
    private Integer age;

    public User(String city, Integer age) {
        this.city = city;
        this.age = age;
    }

    public User() {
    }

    public synchronized void  changAge(){
        this.age = 31;
        notifyAll();
    }

    public synchronized void changeCity(){
        this.city="LonDon";
        notify();
    }

    public synchronized void waitCity(){
        while (this.city.equals("LonDon")){
                try {
                    wait();
                    System.out.println("wait city......."+Thread.currentThread().getId()+"is notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("This city is "+ this.city);
    }

    public synchronized void waitAge(){
        while (this.age<=15){
            try {
                Thread.sleep(5000);
                System.out.println("wait Age ....... "+Thread.currentThread().getId()+"is notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("This age is "+ this.age);
    }

}


