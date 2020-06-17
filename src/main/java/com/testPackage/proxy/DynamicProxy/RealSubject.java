package com.testPackage.proxy.DynamicProxy;

/**
 * 真实类（目标类、被代理类）
 */
public class RealSubject implements  Subject {
    @Override
    public void doSomething() {
        System.out.println("做一些事情。。。");
    }
}
