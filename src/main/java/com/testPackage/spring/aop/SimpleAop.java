package com.testPackage.spring.aop;

import java.lang.reflect.Proxy;

/**
 * 简单Aop
 */
public class SimpleAop {

    public static  Object getProxy(Object bean, Advice advice){

//        loader：一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载
//        interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法。
//        h：一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(),bean.getClass().getInterfaces(),advice);
    }

}
