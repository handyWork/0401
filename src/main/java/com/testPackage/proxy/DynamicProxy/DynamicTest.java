package com.testPackage.proxy.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 测试代理对象
 */
public class DynamicTest {

    public static void main(String[] args) {

        Subject realSubject = new RealSubject();

        // 代理的subject对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, new ProxyHandler(realSubject));
        proxySubject.doSomething();

        System.out.println("代理对象的类型 ： " + proxySubject.getClass().getName());
        System.out.println("代理对象所在类的父类型 ： " + proxySubject.getClass().getGenericSuperclass());

    }
}
