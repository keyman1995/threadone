package com.jay.waitandnotify;

public class TestAge {

    public static User user = new User("LonDon",15);

    private static class CheckAge extends Thread{
        @Override
        public void run() {
            user.waitAge();
        }
    }

    public static class CheckCity extends Thread{
        @Override
        public void run() {
            user.waitCity();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){
            new CheckAge().start();
        }

        for(int i=0;i<3;i++){
            new CheckCity().start();
        }
        Thread.sleep(3000);
        user.changAge();


    }

}
