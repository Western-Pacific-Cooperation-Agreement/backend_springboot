package com.wpca.test;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class MyThread extends Thread{
    boolean a=false;
     int time=1000;
    int num=1;

    //重写run()方法
    @SneakyThrows
    public void run(){
        while(!a){

            System.out.println(Thread.currentThread().getName()+":"+num++);
            Thread.sleep(time);
        }
    }
}


class Testss {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
		t1.start(); //启动线程


        Thread.sleep(10000);
        t1.time=4000;


        Thread.sleep(20000);
        t1.a=!t1.a;

//		t2.start();
//        t1.run();
//        t2.run(); //1.只有主线程一条执行路径 2.依次调用了两次run()方法
    }
}

