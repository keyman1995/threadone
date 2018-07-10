package com.jay.aop.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义了一个切面 通过注解@Aspect
 */
@Aspect
public class AopDemo {

    @Pointcut("execution(** com.jay.aop.aspectj.Computer.work(..))")
    public void aopDemo() {}

    @Before("aopDemo()")
    public void aopMethodBefore(){
        System.out.println("Before do something");
    }
    @After("aopDemo()")
    public void aopMethodAfter(){
         System.out.println("After Aop do something");
     }


    /**
     * execution(** com.jay.aop.aspectj.Computer.showName(..)) && args(name) 切点的定义 何处使用通知
     * 切面定义了合适使用通知
     * showName(..) 这个定义了连接点
     * @param name
     */
    @After("execution(** com.jay.aop.aspectj.Computer.showName(..)) && args(name)")
    public void doName(String name){
         System.out.println("Do you really wants know his name"+name);
     }
}
