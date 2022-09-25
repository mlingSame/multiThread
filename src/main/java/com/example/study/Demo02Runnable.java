package com.example.study;
/**
 * @Author: mlingOkay
 * @CreateTime: 2022-08-06  11:02
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo02Runnable implements Runnable{
    @Override
    public void run() {
        int num=20;
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName()+"我在听课====");
        }
    }


    public static void main(String[] args) {
        //可以明显的看出来start是交替执行的
        Demo02Runnable runnable = new Demo02Runnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
