package com.testPackage.threadTest;
//同步方法和非同步方法是否可以同时调用？  结论： 可以同时调用的
public class demo  {

    public synchronized  void test1(){
        System.out.println(Thread.currentThread().getName()+" test1 star");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" test1 end-------");


    }
    public void test2() {
        System.out.println(Thread.currentThread().getName()+" test2 start-------");

        System.out.println(Thread.currentThread().getName()+" test1 end-------");
    }
    public static void main(String[] args) {

        demo demo = new demo();
        new Thread(demo::test1).start();
        new Thread(demo::test2).start();
    }


}
