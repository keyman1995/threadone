package com.jay.aop.pojodemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AopExecution {
//POJO 轻量级的最小侵入性编程
    public void beforeAop(JoinPoint joinPoint){
        System.out.println("Computer System Before Running"+joinPoint.getArgs()[0]);
    }

    public void afterAop(JoinPoint joinPoint){
        System.out.println("Computer System After Running"+joinPoint.getTarget());
    }

    public void AroundAop(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("Aroud Computer Before Running");
            proceedingJoinPoint.proceed();
            System.out.println("Aroud Computer After Running");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
