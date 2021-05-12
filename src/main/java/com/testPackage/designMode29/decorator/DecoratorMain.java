package com.testPackage.designMode29.decorator;

import org.assertj.core.util.Lists;

import java.util.ArrayList;

/**
 * 装饰者模式测试
 * 装饰者模式主要应用在Java的I/O流中，如果读者对I/O流体系比较混乱的话，不妨利用装饰者模式去理理思路。
 * https://blog.csdn.net/csdn15698845876/article/details/81544562
 */
public class DecoratorMain {

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.function();
        System.out.println("装饰前-----------");

        ConcreteDecorator concreteDecorator = new ConcreteDecorator(concreteComponent);
        concreteDecorator.function();

        System.out.println("装饰后------------");

    }
}
