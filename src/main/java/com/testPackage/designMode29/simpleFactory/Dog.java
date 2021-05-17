package com.testPackage.designMode29.simpleFactory;

public class Dog extends Animal {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    void call() {
        System.out.println("我是" + name + "我会汪汪的叫");
    }

    @Override
    public void AddWeapon() {
        System.out.println("我增加了弹力靴功能，我跳的很高");
    }
}
