package com.testPackage.ObserverTest;

public interface Subject {
    /**
     * 添加观察者
     */
    void add(Observer observer);

    /**
     * 删除观察者
     */
    void del(Observer observer);

    /**
     * 通知所有的观察者
     */
    void notifyObservers();

    /**
     * 自身的操作
     */
    void opration();
}
