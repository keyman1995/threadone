package com.jay.classloader;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestLoader {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InterruptedException {
        /**
         * 双亲委派模型:（逻辑上的上下级关系）
         * 为了避免重复加载，如果一个类加载器收到了类加载的请求；
         * 首先不会自己尝试去加载这个类而是把这个请求委派给父加载器去完成，每一个层次的加载器都是如此，因此所有的类加载器加载请求是都会传给顶层的启动类加载器
         * 已有当父类加载器反馈自己无法完成该加载请求（该加载器的搜索范围中没有找到对应的类）时，子加载器才会尝试自己去加载。
         */
        URL parentUlr = new URL("file:D:\\.m2\\repository\\com\\loader\\test\\loader\\1.0-SNAPSHOT\\loader-1.0-SNAPSHOT.jar");
        URLClassLoader parentclassLoader = new URLClassLoader(new URL[]{parentUlr});
        while (true){
            //优化 该jar包的时间 和当前时间是否不同 再去变更
            URL classUlr = new URL("file:D:\\.m2\\repository\\com\\loader\\test\\loader\\1.0-SNAPSHOT\\loader-1.0-SNAPSHOT.jar");
            //由于在父类加载器已经加载好了该类所有不需要再次重复加载了
            URLClassLoader classLoader = new URLClassLoader(new URL[]{classUlr},parentclassLoader);
            Class<?> loadClass = classLoader.loadClass("com.loader.test.MainerServer");
            Object testClass = loadClass.newInstance();
            loadClass.getMethod("eat").invoke(testClass);
             //什么情况下 调用了GC呢？
            //条件一：当这个类的实例都被GC了
            //条件二：类加载器都已经被GC了。
            System.gc();
            Thread.sleep(3000);
        }

    }
}
