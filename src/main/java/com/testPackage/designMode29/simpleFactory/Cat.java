package com.testPackage.designMode29.simpleFactory;

/**
 * 猫
 */
public class Cat extends Animal {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    void call() {

        System.out.println("我是" + name + "我会喵喵的叫");

    }

    @Override
    public void AddWeapon() {
        System.out.println("我增加了隐形的翅膀我会飞了");
    }
}
