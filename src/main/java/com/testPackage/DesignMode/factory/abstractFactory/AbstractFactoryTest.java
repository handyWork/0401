package com.testPackage.DesignMode.factory.abstractFactory;

/**
 * 测试类
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        //  获取一个形状工厂
        AbstractFactory shapeFfactory = FactoryProducter.getFactory("shape");

        //  获取一个正方形对象
        Shape shape = shapeFfactory.getShape("Square");

        //  创建一个正方形
        shape.draw();


        AbstractFactory colorFactory = FactoryProducter.getFactory("color");

        Color red = colorFactory.getColor("red");

        red.fill();

    }
}
