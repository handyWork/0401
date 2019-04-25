package com.testPackage.threadTest;

import static com.testPackage.proxy.MonitorUtil.start;

public class demo1 implements Runnable {

    private String account;
    private String amont;
    int count = 10;

    //synchronized   锁的是对象，不是锁的代码块
    @Override
    public synchronized void run() {
        count--;
        System.out.println(count);
    }

    public void test() {
        System.out.println("I am test");
    }

    public static void main(String[] args) {
        demo1 demo1 = new demo1();
        for(int i = 0;i<5;i++){
            Thread thread = new Thread(demo1);
            thread .start();
//            new Thread(demo1).start();
        }

    }


}
