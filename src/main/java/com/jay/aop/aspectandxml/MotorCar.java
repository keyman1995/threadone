package com.jay.aop.aspectandxml;

import org.springframework.stereotype.Component;

@Component
public class MotorCar implements Car {

    public void run(String speed) {
        System.out.println("This is a MotorCar Running");
    }
}
