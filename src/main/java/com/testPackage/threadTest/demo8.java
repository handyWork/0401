package com.testPackage.threadTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @Author handy
 * @Date 2021/7/22 下午2:21
 * @Version 1.0
 * 异步处理一些时间比较久的逻辑
 */
public class demo8 {

    public static void main(String[] args) throws Throwable, ExecutionException {
        // 两个线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //jdk1.8之前的实现方式
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("task started!");
                try {
                    //模拟耗时操作
                    longTimeMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "task finished!";
            }
        }, executor);

        //采用lambada的实现方式
        future.thenAccept(e -> System.out.println(e + " ok"));

        System.out.println("main thread is running");
    }


    static class Thead2 extends Thread {


    }

    private static void longTimeMethod() throws InterruptedException {
        Thead2 thead2 = new Thead2();
        thead2.sleep(1000);
        System.out.println("执行插入操作````");
    }

}


