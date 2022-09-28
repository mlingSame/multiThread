package com.example.study;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class demo02ThreadLodimg extends Thread {
    private  String url;
    private  String name;

    public demo02ThreadLodimg(String url, String name) {
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
        demo02ThreadLodimg t1 = new demo02ThreadLodimg("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg", "1.jpg");
        demo02ThreadLodimg t2 = new demo02ThreadLodimg("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg","2.jpg");
        demo02ThreadLodimg t3 = new demo02ThreadLodimg("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg", "3.jpg");
        t1.start();
        t2.start();
        t3.start();

    }
}
