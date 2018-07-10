package com.jay.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestA {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        Computer computer = (Computer) applicationContext.getBean("computer");
       computer.work();
        // computer.showName("ThinkPad");
    }
}
