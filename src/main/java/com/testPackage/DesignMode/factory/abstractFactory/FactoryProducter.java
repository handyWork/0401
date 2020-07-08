package com.testPackage.DesignMode.factory.abstractFactory;

/**
 *  创建一个工厂创造器  通过传递形状或者颜色信息来获取工厂
 */
public class FactoryProducter {

    public static AbstractFactory getFactory(String choice) {


        if ("shape".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        }

        if ("color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }

        return null;

    }

}
