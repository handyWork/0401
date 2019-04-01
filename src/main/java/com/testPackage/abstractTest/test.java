package com.testPackage.abstractTest;

public class test extends DuckFactory {

    public test(String name, String street) {
        super(name, street);
    }

    static {
        System.out.println("我是静态代码块");
    }

    public static void sout(){
        System.out.println("==================");
    }

}
