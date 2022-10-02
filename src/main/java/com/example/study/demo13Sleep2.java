package com.example.study;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  19:17
 * @Description: 模拟倒计时   每个对象都有一个锁，sleep不会释放锁
 * @Version: 1.0
 */
public class demo13Sleep2 {
    public static void testDown() throws InterruptedException{
        int num=10;
        while (true){
                Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
             date = new Date(System.currentTimeMillis());
        }
//        testDown();
    }
}
