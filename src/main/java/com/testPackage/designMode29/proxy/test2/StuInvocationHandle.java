package com.testPackage.designMode29.proxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @param <T>
 */
public class StuInvocationHandle<T> implements InvocationHandler {
    //invocationHandler持有被代理对象
    T target;

    public StuInvocationHandle(T target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args 代表传进去的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("正在执行"+method.getName()+"方法");

        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());

        return result;
    }
}






























