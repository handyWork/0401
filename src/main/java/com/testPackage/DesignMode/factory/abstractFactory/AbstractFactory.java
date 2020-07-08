package com.testPackage.DesignMode.factory.abstractFactory;

/**
 * 创建一个抽象工厂
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 */
public abstract class AbstractFactory {

    // 获取颜色
    public abstract Color getColor(String color);
    // 获取形状
    public abstract Shape getShape(String shape);
}
