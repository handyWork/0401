package com.testPackage.threadTest;

public class demo4 implements  Runnable{

    //和  demo3中实现方法是一样的  new Thread(demo3::test).start();
    @Override
    public void run() {
        synchronized (this){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        demo4 demo3 = new demo4();
        new Thread(demo3).start();
        new Thread(demo3).start();
    }



}
