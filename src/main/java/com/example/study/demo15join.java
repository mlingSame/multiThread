package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  19:33
 * @Description: join强制执行 join合并线程待此vip线程执行完成后再执行其他线程
 * @Version: 1.0
 */
public class demo15join implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
        System.out.println("线程vip开始"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        demo15join demo15join = new demo15join();
        Thread a = new Thread(demo15join, "a");
        a.start();
        for (int i = 0; i < 500; i++) {
            if (i==200){
                a.join();//插队
            }
            System.out.println("main"+i);
        }
    }
}
