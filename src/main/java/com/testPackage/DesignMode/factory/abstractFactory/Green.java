package com.testPackage.DesignMode.factory.abstractFactory;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("填充为绿色");
    }
}
