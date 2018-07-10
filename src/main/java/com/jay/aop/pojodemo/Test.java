package com.jay.aop.pojodemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pojoaop.xml");
        Computer computer = (Computer)context.getBean("computer");
        computer.work(1);
        computer.progress();
    }
}
