package com.testPackage.threadTest;

public class demo {
    private int count = 10;
    private Object object = new Object();

    public void teset(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+"count = "+count);
        }
    }

    public static void main(String[] args) {

        demo demo = new demo();
        demo.teset();
    }


}
