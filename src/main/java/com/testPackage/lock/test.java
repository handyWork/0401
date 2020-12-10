package com.testPackage.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {


    private String buildLock(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        String lock = sb.toString().intern();
        return lock;
    }

    public String saveYhyhq(String a, String b, String c) {

        System.out.println("执行开始");

//        String s = buildLock(b, c);
        synchronized ("bc"){
        System.out.println("进入save  方法中"+b+c);
        }
        System.out.println("执行完成");

        return a + b;

    }

    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        String aaa = "0";
        for (int i = 0; i < 5; i++) {
            aaa = aaa + String.valueOf(i);
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    test test = new test();
                    test.saveYhyhq("", "b", "c");
                }
            });
        }

    }


}
