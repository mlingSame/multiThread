package com.example.study2;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-03  11:01
 * @Description: 测试juc安全类型的juc
 * 线程安全的 List
 * CopyOnWriteArrayList< T > 在 JUC 包下
 * @Version: 1.0
 */
public class demo04testJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
               list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(100);
        System.out.println(list.size());
    }
}
