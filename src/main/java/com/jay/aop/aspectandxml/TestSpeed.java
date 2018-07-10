package com.jay.aop.aspectandxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpeed {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("car.xml");
        Car car = (Car) applicationContext.getBean("motorCar");
        car.run("300Km/h");
    }
}
