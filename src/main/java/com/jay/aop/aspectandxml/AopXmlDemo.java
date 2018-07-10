package com.jay.aop.aspectandxml;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AopXmlDemo {

    @Before("execution(** com.jay.aop.aspectandxml.Car.run(..))&& args(speed)")
    public void testSpeed(String speed){
        System.out.println("Now Speed is"+speed);
    }


}
