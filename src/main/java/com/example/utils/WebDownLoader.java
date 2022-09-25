package com.example.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-08-06  11:02
 * @Description: 网图下载
 * @Version: 1.0
 */
public class WebDownLoader {
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("downloader出现问题");
        }
    }
}
