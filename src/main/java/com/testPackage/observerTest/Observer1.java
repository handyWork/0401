package com.testPackage.observerTest;

public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received");
    }

}
