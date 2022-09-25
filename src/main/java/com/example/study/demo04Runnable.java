package com.example.study;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class demo04Runnable extends Thread {
    private  String url;
    private  String name;

    public demo04Runnable(String url, String name) {
        this.url = url;
        this.name = name;
    }
    //下载线程执行ti
    @Override
    public void run(){
        webDownloader webDownloader=new webDownloader();
        webDownloader.download(url,name);//线程不一定执行，cpu安排调度
        System.out.println("下载了文件名为："+name);
    }

    /**
     *
     * @description:网图下载
     * @return:
     * @author: mLingOkay
     * @time: 2022/6/29 15:29
 */
    class webDownloader{
         public void download(String url,String name){
             try {
                 FileUtils.copyURLToFile(new URL(url),new File(name));
             } catch (IOException e) {
                 e.printStackTrace();
                 System.out.println("IO异常");
             }
         }
}
    public static void main(String[] args) {
        demo04Runnable t1 = new demo04Runnable("https://uploadfile.huiyi8.com/2014/0731/20140731030854722.jpg", "1.jpg");
        demo04Runnable t2 = new demo04Runnable("https://uploadfile.huiyi8.com/2014/0731/20140731030854722.jpg", "2.jpg");
        demo04Runnable t3 = new demo04Runnable("https://uploadfile.huiyi8.com/2014/0731/20140731030854722.jpg", "3.jpg");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
