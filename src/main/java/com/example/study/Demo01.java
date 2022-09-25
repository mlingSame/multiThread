package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-08-06  11:02
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo01 extends Thread{


    @Override
    public void run() {
        //线程体
        int num=200;
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName()+"我在听课====");
        }
    }


    public static void main(String[] args) {

        Demo01 threadss = new Demo01();
        threadss.run();
//          threadss.start();
        int num=200;
        for (int i = 0; i < num; i++) {
            System.out.println("读书我在===");
        }
        //start是先读书再听课 //多条交替执行
        //run是先听课再读书 只有主线程一条执行路径
    }
}
