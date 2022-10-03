package com.example.study2;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-03  13:43
 * @Description: TODO测试生产者消费者：管程法
 *
 * 生产者:负责生产数据的模块(可能是方法，对象，线程﹐进程);
 * 消费者︰负责处理数据的模块(可能是方法﹐对象，线程，进程);
 * 缓冲区:消费者不能直接使用生产者的数据﹐他们之间有个“缓冲区生产者将生产好的数据放入缓冲区,消费者从缓冲区拿出数据
 *
 * @Version: 1.0
 */
public class Demo08TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container=container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container=container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.get().id+"只鸡");
        }
    }

}
//产品
class Chicken{
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{
    //需要一个容器大小
   Chicken[] chickens= new Chicken[10];
   int count=0;
   //将生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，则需要等待消费消费
        if (count==chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，则需要丢入产品
        chickens[count]=chicken;
        count++;
        //可以通知消费者消费了
    }


    //将消费者取出产品
    public synchronized Chicken get( ){
        //如果容器为空，则等待生产者生产
        if (count==0){
            //通知生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果容器满了，则需要取出产品
        count--;
        Chicken chicken=chickens[count];

        //可以通知消费者消费了
        //吃完啦通知生产者生产
        return chicken;
    }

}

