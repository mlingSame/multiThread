package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-09-28  22:02
 * @Description: 多个线程操作同一个对象  发现问题 两个人同时拿到一张票和最后拿到第0条票
 * @Version: 1.0
 */
public class demo05mulThread implements Runnable{

    int ticket=10;//票数

    @Override
    public void run() {
       while (true){
           if (ticket<=0){
               break;
           }
           try {
               //模拟延时
               Thread.sleep(200);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+"拿到了第"+ticket--+"票");
       }
    }

    public static void main(String[] args) {
        demo05mulThread demo = new demo05mulThread();
        new Thread(demo,"小明").start();
        new Thread(demo,"老师").start();
        new Thread(demo,"黄牛").start();
    }
}
