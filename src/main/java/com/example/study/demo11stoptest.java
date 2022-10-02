package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-02  19:05
 * @Description: 建议线程正常停止 不建议死循环 通过标志位 不要使用stop或者destory等过时方法
 * @Version: 1.0
 */
public class demo11stoptest implements Runnable{


    //1.设置一个标志位
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("thread。。。");
        }
    }
    //对外提供的停止线程的方法
    public void  teststop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        demo11stoptest demo11stoptest = new demo11stoptest();
        new Thread(demo11stoptest).start();
        for (int i = 0; i < 900; i++) {
            System.out.println("main" + i);
            if (i==800){
                //调换stop方法，切换标志位
                demo11stoptest.teststop();
            }
        }
    }
}
