package com.example.study;

public class demo01 extends Thread{

    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在听课====");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        demo01 threadss = new demo01();
//        threadss.run();
          threadss.start();
        for (int i = 0; i < 30; i++) {
//            Thread.sleep(1000);
            System.out.println("读书我在===");
        }
        //start是先读书再听课 //多条交替执行
        //run是先听课再读书 只有主线程一条执行路径
    }
}
