package com.example.study2;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-03  11:12
 * @Description:
 *  产生的死锁的四个条件
 *      1.互斥条件：一个资源每次只能被一个进程使用
 *      2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放
 *      3.不剥夺条件：进程以获取的资源，在未使用之前，不能强行剥夺
 *      4.循环等待条件：若干进行之间形成一种头尾相接的循环等待资源关系
 * @Version: 1.0
 */
public class demo05Deadlock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "小红");
        Makeup g2 = new Makeup(1, "小绿");
        g1.start();
        g2.start();
    }
}
class lipstick{

}
class mirror{

}
class Makeup extends Thread{
    //需要的资源只有一份，用static来保证只有一份
       static lipstick lipstick=new lipstick();
        static mirror mirror=new mirror();

        private int choice;//选择
        private String girlName;//女生的名字

    public Makeup(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }
    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipstick){
                System.out.println(this.girlName+"口红的锁");
                Thread.sleep(100);
                //会产生死锁
//                synchronized (mirror){
//                    System.out.println(this.girlName+"镜子的锁");
//                }
            }
            synchronized (mirror){
                System.out.println(this.girlName+"镜子的锁");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"镜子的锁");
                Thread.sleep(100);
                //会产生死锁
//                synchronized (lipstick){
//             System.out.println(this.girlName+"口红的锁");
//            }
            }
            synchronized (lipstick){
                System.out.println(this.girlName+"口红的锁");

            }
        }
    }
}