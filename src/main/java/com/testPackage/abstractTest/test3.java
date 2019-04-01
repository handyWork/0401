package com.testPackage.abstractTest;

public class test3 extends  test2  implements InterfaceTest{

    test3 t3 = new test3();
    @Override
    public void test() {
        System.out.println("重写方法");
    }
}
