package com.jay.aop.aspectj;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MyBeanConfig {

    @Bean
    public AopDemo aopDemo(){
        return new AopDemo();
    }

    @Bean
    public ComputerSystem computerSystem(){
        return new Win7();
    }

    @Bean
    public Computer computer(){
        return new Computer(computerSystem());
    }


}
