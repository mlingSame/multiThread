package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  19:26
 * @Description: 礼让线程，让当前正在执行的线程暂停。但不阻塞
 * 将线程从运行状态转为就绪状态‘
 * 让cpu冲心调度，礼让不一定成功，看cpu心情
 * @Version: 1.0
 */
public class demo14Yield implements Runnable{
    @Override
    public void run() {
        System.out.println("线程开始执行"+Thread.currentThread().getName());
        Thread.yield();;//礼让
        System.out.println("线程结束"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        demo14Yield demo14Yield = new demo14Yield();
        new Thread(demo14Yield,"a").start();
        new Thread(demo14Yield,"b").start();
    }

}
