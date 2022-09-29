package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-09-29  09:40
 * @Description: 3.1 静态代理模式总结
 * 1. 真实对象和代理对象都要实现同一个接口
 * 2. 代理对象要代理真实角色
 * 3.2 静态代理好处
 * 1. 代理对象可以做很多真实对象做不了的事
 * 2. 真实对象专注做自己的事
 * Thread 实现 Runnable 接口，Thread 只是代理对象。
 * @Version: 1.0
 */
public class demo08staticProxy {
    public static void main(String[] args) {
        //自己结婚
//        you lishi=new you();
//        lishi.HappyMarry();
        //静态代理
        new wendding(new you()).HappyMarry();


    }
}
interface  Marry{
    void HappyMarry();
}
//自己结婚
class you implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了！");
    }
}
//婚庆公司使用静态代理
class  wendding implements Marry{
    Marry target;

    public wendding(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("收份子钱");
    }

    private void before() {
        System.out.println("开始准备");
    }
}
