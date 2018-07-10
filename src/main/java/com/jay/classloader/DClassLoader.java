package com.jay.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DClassLoader extends ClassLoader {

    private String name;

    public DClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        Class<?> clazz = null;

        ClassLoader system = getSystemClassLoader();

        try{
            clazz = system.loadClass(name);
        }catch (Exception e){

        }
        if(clazz!=null){
            return clazz;
        }
        clazz = findClass(name);
        return clazz;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream is = null;
        byte[]data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            is = new FileInputStream("E:\\IDEAProject\\thread\\loader\\target\\classes\\com\\loader\\test\\MainerServer.class");
            int c = 0;
            while((c=is.read())!=-1){
                baos.write(c);
            }
            data = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.defineClass(name,data,0,data.length);
    }

    public static void main(String[] args) {

        DClassLoader classLoader = new DClassLoader(DClassLoader.class.getClassLoader(),"TomcatLoader");

        Class clazz;
        try{
            clazz = classLoader.loadClass("com.loader.test.MainerServer");
            Object o = clazz.newInstance();
            clazz.getMethod("eat").invoke(o);
        }catch (Exception e){
            e.printStackTrace();
        }

    }





}
