package com.example.study2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-03  13:20
 * @Description: ReentrantLock 可重入锁
 * lock和synchroinized对比
 * 1.lock是显是锁，synchronized是隐式锁，出了作用域自动释放
 * 2.lock只有代码块锁，synchronized有代码锁和方法锁
 * 3.使用lock锁，jvm将花费较少的时间来调度线程，性能更好。并且具有更好的扩展类
 * 使用顺序
 * lock>同步代码块（已经进入了方法体，分配了相应的资源）>同步方法（在方法体之外。）
 * @Version: 1.0
 */
public class demo06testLock {
    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(testLock,"zhangsna").start();
        new Thread(testLock,"zhangsna2").start();
        new Thread(testLock,"zhangsna3").start();
    }
}
class TestLock implements Runnable{

    int tickNum=10;
    //定义lock锁
    private final ReentrantLock lock1=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock1.lock();//加锁
            try {
                //加锁的代码块
                if (tickNum>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"票数"+tickNum--);
                }
            }finally {
                lock1.unlock();//解锁
                //如果同步代码有异常,要将unlock写入finally语句中
            }

        }
    }
}
