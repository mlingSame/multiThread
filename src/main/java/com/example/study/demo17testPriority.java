package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  19:58
 * @Description: 测试优先级 优先级会占比大 但是不一定先跑 大多数的时候会先跑
 * 先设置优先级再启动
 * @Version: 1.0
 */
public class demo17testPriority {
    public static void main(String[] args) {
        //主线程的优先级
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
        myPriority myPriority = new myPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3= new Thread(myPriority);
        Thread t4= new Thread(myPriority);
        Thread t5= new Thread(myPriority);
        Thread t6 = new Thread(myPriority);
        Thread t7= new Thread(myPriority);

        t1.start();
        t2.setPriority(2);
        t2.start();
        t3.setPriority(3);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t7.setPriority(1);
        t7.start();

        t5.setPriority(-1);
        t5.start();
        t6.setPriority(12);
        t6.start();

    }
}
class myPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}