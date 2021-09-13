package com.testPackage.threadTest;

/**
 * @author handy
 * @version 1.0
 * @date 2021/9/13 20:25
 */
public class demo8 {


    public static void main(String[] args) {

        Object lock = new Object();

        char[] ai = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();


        new Thread(() -> {

            synchronized (lock) {
                for (int i = 0; i < ai.length; i++) {
                    try {
                        System.out.println(ai[i]);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < ac.length; i++) {
                    try {
                        System.out.println(ac[i]);
                        lock.notify(); 
                        lock.wait();  // 让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify(); // 必须， 否则无法停止程序
            }

        }).start();


    }
}
