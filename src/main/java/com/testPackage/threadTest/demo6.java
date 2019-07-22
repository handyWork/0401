package com.testPackage.threadTest;

import java.util.ArrayList;
import java.util.List;

/**
 *    notify不会释放当前锁  wait 会释放锁
 */
public class demo6 {

    private static List list = new ArrayList();

    public void listAdd() {
        list.add("qweqwe");
    }

    public int size() {
        return list.size();
    }


    public static void main(String[] args) {

        demo6 demo6 = new demo6();

        Object lock = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        for (int i = 0; i < 10; i++) {
                            demo6.listAdd();
                            System.out.println("当前线程" + Thread.currentThread().getName() + "添加了一个元素");
                            Thread.sleep(500);
                            if(demo6.size() == 5){
                                System.out.println("已经发出通知");
                                lock.notify();//  唤醒当前线程   notify不会释放当前锁
                            }
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
                synchronized (lock) {
                    if (demo6.size() != 5) {
                        try {
                            lock.wait();//wait 会释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程" + Thread.currentThread().getName() +"已经接到通知···");
                    throw new RuntimeException();
                }
            }
        }, "t2");

        thread2.start();
        thread.start();

    }

}
