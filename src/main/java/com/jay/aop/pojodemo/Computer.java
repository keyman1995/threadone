package com.jay.aop.pojodemo;


public class Computer {

    private ComputerSystem computerSystem;

    public Computer(ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }

    public void work(int args){
        computerSystem.run();
    }

    public void progress(){
        System.out.println("Computer is Progressing");
    }


}
