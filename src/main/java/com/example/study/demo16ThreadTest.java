package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  19:46
 * @Description: TODO 线程的五个状态
 * @Version: 1.0
 */
public class demo16ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("/////");
            }
        });
        //观察状态
        Thread.State state = thread.getState();//NEW
        System.out.println(state);
        //启动线程
        thread.start();//调用完start方法不意味着立即调度执行
        //观察状态
         state = thread.getState();
        System.out.println(state);//RUNNABLE
        //只要线程不终止，就一直输出状态
        while (state!=Thread.State.TERMINATED){
            Thread.sleep(100);//G
            state = thread.getState();//输出状态
            System.out.println(state);//TIMED_WAITIN
        }
    }
}
