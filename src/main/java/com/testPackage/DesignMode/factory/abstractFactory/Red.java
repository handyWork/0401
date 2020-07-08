package com.testPackage.DesignMode.factory.abstractFactory;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("填充为红色");
    }
}
