package com.testPackage.abstractTest;

//这是一个抽象类
public abstract class DuckStore  {

    private String name;
    private String street;

    //抽象方法
    abstract void doing();

    abstract void eat();

    public DuckStore(String name, String street) {
        this.name = name;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    //不是抽象方法
    public void isNotAbstract() {
    }

    ;
//    public abstract  void isAbstract();
}
