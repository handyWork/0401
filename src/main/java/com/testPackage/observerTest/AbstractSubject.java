package com.testPackage.observerTest;

import java.util.Enumeration;
import java.util.Vector;
//  因为这个是抽象   如果是抽象类实现接口，可以一个接口中的方法都不实现或者实现部分方法
public abstract   class AbstractSubject implements Subject {

    private  Vector<Observer>  vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> elements = vector.elements();
        while (elements.hasMoreElements()){
            elements.nextElement().update();
        }
    }

//    @Override
//    public void opration() {
//
//    }
}
