package com.testPackage.ObserverTest;

//实现接口 或者  继承抽象类的子类必须实现接口的所有方法
public class MySubject extends AbstractSubject {
    @Override
    public void opration() {
        System.out.println("update myself");
        //通知所有的观察者
        notifyObservers();
    }
}
