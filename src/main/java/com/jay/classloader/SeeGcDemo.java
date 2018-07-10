package com.jay.classloader;


import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * -verbose:class -verbose:gc 可以直观看到GC 和 class 运行情况
 */
public class SeeGcDemo {

    public static void main(String[] args) {

        System.out.println("=========================String "+String.class.getClassLoader());
        System.out.println("+++++++++++++++++++++++DNSNameServcice"+ DNSNameService.class.getClassLoader());
        SeeGcDemo seeGcDemo = new SeeGcDemo();
        System.out.println("====================seeGcDemo"+seeGcDemo.getClass().getClassLoader());
        System.out.println("====================seeGcDemo 的Parent"+seeGcDemo.getClass().getClassLoader().getParent());
        System.out.println("====================seeGcDemo 的Parent的parent"+seeGcDemo.getClass().getClassLoader().getParent().getParent());

        System.out.println("Hello World");
    }

}
