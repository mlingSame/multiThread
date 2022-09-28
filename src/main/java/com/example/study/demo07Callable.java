package com.example.study;

import com.example.utils.WebDownLoader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * Callable接口
 */
public class demo07Callable implements Callable<Boolean> {
    private  String url;
    private  String name;

    public demo07Callable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader webDownloader=new WebDownLoader();
        webDownloader.downLoader(url,name);//线程不一定执行，cpu安排调度
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        demo07Callable c1 = new demo07Callable("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg", "1.jpg");
        demo07Callable c2 = new demo07Callable("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg", "2.jpg");
        demo07Callable c3 = new demo07Callable("https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg", "3.jpg");
        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> resture1 = executorService.submit(c1);
        Future<Boolean> resture2 = executorService.submit(c2);
        Future<Boolean> resture3 = executorService.submit(c3);
        //获取结果
        Boolean r1 = resture1.get();
        Boolean r2 = resture2.get();
        Boolean r3 = resture3.get();
        //关闭服务
        executorService.shutdownNow();

    }
}

