package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  20:09
 * @Description: 线程分为用户线程（main,GC）和守护线程
 * 虚拟机必须确保用户线程执行完毕 虚拟机不用等待守护线程执行完毕
 * @Version: 1.0
 */
public class demo18daemo {
    public static void main(String[] args) {
        You111 you = new You111();
        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//正常的线程都是用户线程 默认是false表示的是用户线程
        thread.start();
         new Thread(you).start();
    }
}

class God implements Runnable{
    @Override
    public void run() {
        System.out.println("上帝保佑着你");
    }
}
class You111 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("活着");
        }
        System.out.println("bey");
    }
}
