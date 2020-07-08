package com.testPackage.DesignMode.factory.abstractFactory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("制作一个正方形");
    }
}
