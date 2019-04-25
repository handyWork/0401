package com.testPackage.observerTest;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 这个类直接去实现了接口 没有通过继承抽象方法来实现   通过继承抽象方法的话，个人认为有了一定的解耦性，功能分化更加明细点     TODO
 */
public class SubjectImpl implements  Subject {

    private Vector<Observer> vector = new Vector<Observer>();
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

    @Override
    public void opration() {
        notifyObservers();
    }
}
