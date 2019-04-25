package com.testPackage.threadTest;

public class demo1 implements Runnable {

    private String account;
    private String amont;
    int count = 10;


    @Override
    public void run() {
        count--;
        System.out.println(count);
    }

    public void test() {
        System.out.println("I am test");
    }

    public static void main(String[] args) {
        demo1 demo1 = new demo1();
        Thread thread = new Thread(demo1);
        for(int i = 0;i<5;i++){
            thread.run();
        }

    }


}
