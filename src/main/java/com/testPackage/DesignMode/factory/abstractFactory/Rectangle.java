package com.testPackage.DesignMode.factory.abstractFactory;

public class Rectangle implements  Shape {

    @Override
    public void draw() {
        System.out.println("制作一个矩形");
    }
}
