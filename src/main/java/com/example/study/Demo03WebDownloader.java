package com.example.study;


import com.example.utils.WebDownLoader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-08-06  11:02
 * @Description: 多线程下载图片
 * @Version: 1.0
 */
public class Demo03WebDownloader extends Thread{
    private String url;
    private String name;

    public Demo03WebDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        Demo03WebDownloader downloader1=new Demo03WebDownloader("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg","图片1.jpg");
        Demo03WebDownloader downloader2=new Demo03WebDownloader("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg","图片2.jpg");
        Demo03WebDownloader downloader3=new Demo03WebDownloader("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg","图片3.jpg");
        downloader1.start();
        downloader2.start();
        downloader3.start();
    }
}
