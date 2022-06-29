/**
 * @description:
 * @author: mLingOkay
 * @time: 2022/6/29 17:23
 */

package com.example.study;
/**
 *
 * @description: 创建线程2，实现runnable接口，重新run方法，执行线程需要丢入runnable接口实现类，调用start方法
 * @return:
 * @author: mLingOkay
 * @time: 2022/6/29 17:24
 */

public class demo03Runnable implements Runnable{
    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"我在听课");
        }
    }
    public static void main(String[] args)  {
//创建runnable接口的实现类对象
        demo03Runnable threadss = new demo03Runnable();
        //创建线程对象，通过线程对象来开启我们的线程代理
//        Thread thread = new Thread(threadss);
//        thread.start();
        new Thread(threadss).start();
//
        for (int i = 0; i < 2000; i++) {
//            Thread.sleep(1000);
            System.out.println(i+"读书我在===");
        }

    }

}
