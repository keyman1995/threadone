package com.jay.aop.springclastic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springaop.xml");
        ComputerSystem computerSystem = (ComputerSystem) context.getBean("systemProxy");
        computerSystem.run();
        computerSystem.running();
    }
}
