package com.testPackage.designMode29.proxy.test2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) {
        //创建一个实例对象  这个是被代理的对象
        Student zhangSan = new Student("张三");
        //创建一个与代理对象相关联的invocationHandler
        InvocationHandler stuHandler = new StuInvocationHandle<Person>(zhangSan);
        //创建出一个代理对象stuProxy来代理张三，代理对象中的每个执行方法都会替换invocation中的invoke方法
        Person  stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

//==========================================================  这块是进行测试用的
        //这里可以通过运行结果证明stuProxy是Proxy的一个实例，这个实例实现了stuProxy接口
        System.out.println(stuProxy instanceof Proxy);

        //这里可以看出stuProxy的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了stuProxy接口
        System.out.println("stuProxy的Class类是："+stuProxy.getClass().toString());

        System.out.print("stuProxy中的属性有：");

        Field[] field=stuProxy.getClass().getDeclaredFields();
        for(Field f:field){
            System.out.print(f.getName()+", ");
        }

        System.out.print("\n"+"stuProxy中的方法有：");

        Method[] method=stuProxy.getClass().getDeclaredMethods();

        for(Method m:method){
            System.out.print(m.getName()+", ");
        }

        System.out.println("\n"+"stuProxy的父类是："+stuProxy.getClass().getSuperclass());

        System.out.print("\n"+"stuProxy实现的接口是：");

        Class<?>[] interfaces=stuProxy.getClass().getInterfaces();

        for(Class<?> i:interfaces){
            System.out.print(i.getName()+", ");
        }

        System.out.println("\n\n"+"运行结果为：");
//==========================================================

        //代理执行交班费的方法
        stuProxy.giveMoney();

    }

}
