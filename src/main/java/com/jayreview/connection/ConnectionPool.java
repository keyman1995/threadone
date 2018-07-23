package com.jayreview.connection;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    private int initalSize;

    public ConnectionPool(int initalSize) {
        this.initalSize = initalSize;
        if(this.initalSize>0){
            for(int i=0;i<initalSize;i++){
                pool.addLast(ConnectionDriver.getConnection());
            }
        }
    }


    public void releaseConnection(Connection connection){
        if(connection!=null){
            synchronized (pool){
                //添加后需要进行通知这样其他消费者能够知道连接池中有连接了
                System.out.println(Thread.currentThread().getName()+"释放了连接========================"+System.currentTimeMillis());
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }


    /**
     * 获取连接
     */
    public Connection fetchConnetion(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills<=0){
                System.out.println("------------------连接已经超时");
                return null;
            }else{
                long future = System.currentTimeMillis()+mills;//超时的时间
                long remaining = mills;//超时时长
                while (pool.isEmpty()&&remaining>0){
                    pool.wait(remaining);
                    System.out.println(Thread.currentThread().getName()+"+++++++++++++++++++++"+remaining);
                    remaining = future-System.currentTimeMillis();//还需要等待的时长
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

}
