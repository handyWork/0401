package com.testPackage.threadTest;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock  和  synchronized   的区别
 * Lock是在Java1.6被引入进来的，Lock的引入让锁有了可操作性，Lock 是我们在需要的时候去手动的获取锁和释放锁，甚至我们还可以中断获取以及超时获取的同步特性，但是从使用上说Lock明显没有synchronized使用起来方便快捷。
 * 当synchronized锁住一个对象之后，别的线程如果想要获取锁对象，那么就必须等这个线程执行完释放锁对象之后才可以，否则一直处于等待状态。
 */
public class demo5  {

    private Lock lock = new ReentrantLock();

    private  void method(Thread thread) {
        lock.lock();
        try {
            System.out.println("线程名：" + thread.getName() + "获得了锁");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("线程名：" + thread.getName() + "释放了锁");
        }
    }

    private void methodTryLock1(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println("线程名：" + thread.getName() + "获得了锁");
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程名：" + thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else{
            System.out.println("获取不到锁对象，我退出！");
        }

    }

    /**
     * 3秒内能否获取到当前锁的对象   tryLock();  获取到则执行
     * @param thread
     * @throws InterruptedException
     */
    private void methodTryLock(Thread thread) throws InterruptedException {
        if (lock.tryLock(3, TimeUnit.SECONDS)) {
            try {
                System.out.println("线程名：" + thread.getName() + "获得了锁");
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程名：" + thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else{
            System.out.println("获取不到锁对象，我退出！");
        }

    }


    public static void main(String[] args) {
        demo5 demo5 = new demo5();
        // 线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {//Thread.currentThread() 返回当前线程的引用
                try {
                    demo5.methodTryLock(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } }, "t1");
        //线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {//Thread.currentThread() 返回当前线程的引用
                try {
                    demo5.methodTryLock(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } }, "t2");
        t1.start();
        t2.start();
    }
}
