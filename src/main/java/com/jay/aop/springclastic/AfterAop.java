package com.jay.aop.springclastic;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
/*定义通知内容，也就是切入点执行前后需要做的事情*/
public class AfterAop implements AfterReturningAdvice {

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("++++++++++++++++++++++++++++Computer System After Running");
    }
}
