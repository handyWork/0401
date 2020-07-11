package com.testPackage.spring.aop;

import org.junit.Test;

/**
 * aop  测试类
 */
public class SimpleAopTest {

    @Test
    public void getProxy(){
        // 1. 创建一个methodInvocation 实现类
        MethodInvocation methodInvocation = () -> System.out.println("log task start");

        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个Advice
        BeforeAdvice beforeAdvice = new BeforeAdvice(helloServiceImpl,methodInvocation);

        // 3. 为目标对象生成一个代理
        HelloService proxy = (HelloService) SimpleAop.getProxy(helloServiceImpl, beforeAdvice);

        proxy.sayHello();


    }
}
