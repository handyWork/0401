package com.testPackage.abstractTest;
//如果这个类不继承抽象类的话 只能在这个类上加上abstract
//如果继承抽象类的话 必须实现抽象类中的所有方法
public class DuckFactory extends  DuckStore {

    public DuckFactory(String name, String street) {
        super(name, street);
    }

    @Override
    void eat() {

    }



    @Override
   public void doing() {
        System.out.println("doing some thing");
    }
}
