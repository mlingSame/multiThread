package com.example.study;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-09-29  11:20
 * @Description: 带参数的lamdba表达式
 * @Version: 1.0
 */
public class demo10lab {

    public static void main(String[] args) {

        love love11 =null;
        love11= (a, b) -> System.out.println(a+","+b);;
        love11.lovelml(1,2);

    }
}
interface love{
    void lovelml(int a,int b);
}

