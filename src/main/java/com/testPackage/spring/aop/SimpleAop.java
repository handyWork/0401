package com.testPackage.spring.aop;

import java.lang.reflect.Proxy;

/**
 * 简单Aop
 */
public class SimpleAop {

    public static  Object getProxy(Object bean, Advice advice){
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(),bean.getClass().getInterfaces(),advice);
    }

}
