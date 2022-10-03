package com.example.study2;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-03  13:39
 * @Description: wait notify
 * @Version: 1.0
 */
public class Demo07TestPC2 {
    public static void main(String[] args) {
        Movie movie = new Movie();
        new Player(movie).start();
        new Audience(movie).start();
    }
}
// 生产者：演员
class Player extends Thread{
    Movie movie;
    public Player(Movie movie){
        this.movie = movie;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                this.movie.play("肖申克的救赎");
            }else{
                this.movie.play("抖音，记录美好生活");
            }
        }
    }
}
// 消费者：观众
class Audience extends Thread{
    Movie movie;
    public Audience(Movie movie){
        this.movie = movie;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.movie.watch();
        }
    }
}
// 产品：节目
class Movie{
    String movieName;
    Boolean flag = true;
    // 演员拍戏，观众等待 T
    // 观众观看，演员等待 F
// 拍戏
    public synchronized void play(String movieName){
        if(!flag){
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员拍了：" + movieName);
        this.movieName = movieName;
        this.flag = false;
        this.notifyAll();
    }
    // 观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了：" + movieName);
        this.flag = true;
        this.notifyAll();
    }
}
