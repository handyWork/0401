package com.testPackage.threadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 *    demo6的另一种实现方式（通过并发包）
 */
public class demo7 {

    private static List list = new ArrayList();

    public void listAdd() {
        list.add("qweqwe");
    }

    public int size() {
        return list.size();
    }


    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(1);  //  这的参数1   是为了发通知要发几次才能唤醒
        demo7 demo6 = new demo7();

        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                        for (int i = 0; i < 10; i++) {
                            demo6.listAdd();
                            System.out.println("当前线程" + Thread.currentThread().getName() + "添加了一个元素");
                            Thread.sleep(500);
                            if(demo6.size() == 5){
                                System.out.println("已经发出通知");
//                                lock.notify();//  唤醒当前线程   notify不会释放当前锁
                                countDownLatch.countDown();
                            }
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    if (demo6.size() != 5) {
                        try {
//                            lock.wait();//wait 会释放锁
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程" + Thread.currentThread().getName() +"已经接到通知···");
                    throw new RuntimeException();
                }
        }, "t2");

        thread2.start();
        thread.start();

    }

}
