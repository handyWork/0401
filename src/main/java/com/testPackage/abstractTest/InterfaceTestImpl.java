package com.testPackage.abstractTest;
//11：抽象类不能实现多继承，接口可以
//一个类不能直接继承多个类，java是单继承语言
public class InterfaceTestImpl extends DuckStore implements InterfaceTest,Interface1 {
//需要重写 抽象类中的所有抽象方法

    public InterfaceTestImpl(String name, String street) {
        super(name, street);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getStreet() {
        return super.getStreet();
    }

    @Override
    public void test() {

    }

    @Override
    void doing() {

    }

    @Override
    void eat() {

    }

    @Override
    public void test1() {

    }
}
