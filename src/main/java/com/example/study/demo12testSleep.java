package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  19:14
 * @Description: TODO
 * @Version: 1.0
 */
public class demo12testSleep implements Runnable{
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
        demo12testSleep demo = new demo12testSleep();
        new Thread(demo,"小明").start();
        new Thread(demo,"老师").start();
        new Thread(demo,"黄牛").start();
    }
}
