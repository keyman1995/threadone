package com.jay.aop.springclastic;


public class Computer {


    private ComputerSystem computerSystem;

    public Computer(ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }

    public void work(){
        computerSystem.run();
    }


}
