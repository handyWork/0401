package com.testPackage.DesignMode.converter;

public class B implements A{

    public B() {
        System.out.println("调用了B的构造函数");
    }

    @Override
    public SqlSessionFactory getObject() {
        System.out.println("实现了A的接口");
        return null;
    }
}
