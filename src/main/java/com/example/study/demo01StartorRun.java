package com.example.study;

public class demo01StartorRun extends Thread{

    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"我在听课");
        }
    }

    /**
     *
     *
     * @description: start是先读书再听课 之后多条交替执行
     *                run是先听课再读书 run执行完了，再执行循环qq1
     *
     * @return:
     * @author: mLingOkay
     * @time: 2022/6/21 19:28
     */
    public static void main(String[] args) throws InterruptedException {

        demo01StartorRun threadss = new demo01StartorRun();
        threadss.run();
//          threadss.start();
        for (int i = 0; i < 2000; i++) {
//            Thread.sleep(1000);
            System.out.println(i+"读书我在===");
        }

    }
}
