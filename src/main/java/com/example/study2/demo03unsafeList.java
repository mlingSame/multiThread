package com.example.study2;

import java.util.ArrayList;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  22:04
 * @Description: ArrayList是不安全的线程
 * @Version: 1.0
 */
public class demo03unsafeList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
           new Thread(()->{
             synchronized (arrayList){  arrayList.add(Thread.currentThread().getName());}
           }).start();
        }
        Thread.sleep(1000);
        System.out.println(arrayList.size());
    }
}
