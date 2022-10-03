package com.example.study2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: mlingOkay
 * @CreateTime: 2022-10-03  14:36
 * @Description:
 * 1.1史用北性心
 * JDK 5.0起提供了线程池相关API: ExecutorService和Executors
 * ExecutorService: 真正的线程池接口。 常见子类ThreadPoolExecutor
 * void execute(Runnable command)︰执行任务/命令，没有返回值，一般用来执行Runnable
 * <T> Future<T> submit(Callable<T> task):执行任务，有返回值，一般又来执行Callable
 * void shutdown():关闭连接池
 * Executors:工具类、线程池的工厂类，用于创建并返回不同类型的线程池
 * @Version: 1.0
 */
public class Demo09TestexecuteThreadPool {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//        // 2. 添加
//        service.execute(new MyThread());
//        service.execute(new MyThread());
//        service.execute(new MyThread());
//        service.execute(new MyThread());
        service.submit(new MyThread());
        service.submit(new MyThread());
        service.submit(new MyThread());
        service.submit(new MyThread());
        // 3. 关闭线程池
        service.shutdown();
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"------>"+i);
        }
    }
}

