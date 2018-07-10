package com.jay.aop.aspectj;

public class Computer {

    private ComputerSystem computerSystem;

    public Computer(ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }

    public void work(){
        computerSystem.run();
    }

    public void showName(String name){
        System.out.println("The Computer is "+name);
    }



}
