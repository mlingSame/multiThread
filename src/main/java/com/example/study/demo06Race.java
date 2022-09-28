package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-09-28  22:08
 * @Description: 龟兔赛跑
 * @Version: 1.0
 */
public class demo06Race implements Runnable{
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子")&&i%10==0){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean b = gameOver(i);
            //判断比赛是否结束
            if (b==true){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }
    //是否完成比赛
    private boolean gameOver(int steps){
        if (winner!=null){
            System.out.println("存在胜利者");
            return true;
        }
        if (steps>=100){
             winner = Thread.currentThread().getName();
            System.out.println(winner+"是winner");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        demo06Race demo06Race = new demo06Race();
        new Thread(demo06Race,"兔子").start();
        new Thread(demo06Race,"乌龟11").start();
    }
}
