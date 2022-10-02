package com.example.study2;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  21:35
 * @Description: 不安全的线案例1
 * @Version: 1.0
 */
public class demo01ByTicket implements Runnable{
    boolean flag=true;//外部停止方式
    private int tickNum=10;
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void buy() throws InterruptedException {
        if (tickNum<=0){
            return;
        }
        //模拟延迟
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"拿到"
        +tickNum--);
    }

    public static void main(String[] args) {
        demo01ByTicket demo01ByTicket = new demo01ByTicket();
        new Thread(demo01ByTicket,"a").start();
        new Thread(demo01ByTicket,"b").start();
        new Thread(demo01ByTicket,"c").start();
    }
}
