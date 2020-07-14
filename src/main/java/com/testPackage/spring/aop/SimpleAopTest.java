package com.testPackage.spring.aop;

import org.junit.Test;

/**
 * aop  测试类
 * 大致思路为：  我有一个真实对象去做A操作时，  我先创建一个代理对象，让代理对象去处理A操作，但是我可以在代理对象处理A操作之前先处理下其他的业务
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
