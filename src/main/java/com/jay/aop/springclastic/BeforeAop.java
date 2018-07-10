package com.jay.aop.springclastic;

import org.springframework.aop.MethodBeforeAdvice;


import java.lang.reflect.Method;
/*定义通知内容，也就是切入点执行前后需要做的事情*/
public class BeforeAop implements MethodBeforeAdvice{

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("-----------------ComputerSystem before running");
    }
}
