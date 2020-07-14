package com.testPackage.spring.aop;

import java.lang.reflect.Method;

/**
 * 前置通知
 */
public class BeforeAdvice implements  Advice {

    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    /**
     * proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * method:我们所要调用某个对象真实的方法的Method对象
     * args:指代代理对象方法传递的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在真实的对象执行之前我们可以添加自己的操作
        methodInvocation.invoke();
        Object invoke = method.invoke(bean, args);
        //在真实的对象执行之后我们可以添加自己的操作
        return invoke;

    }
}
