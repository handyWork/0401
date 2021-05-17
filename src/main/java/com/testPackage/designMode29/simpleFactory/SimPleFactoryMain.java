package com.testPackage.designMode29.simpleFactory;

/**
 * 测试工厂模式
 *
 * 类： 是对对象的抽象
 * 抽象类：是对类的抽象
 * 接口： 是对行为的抽象
 *
 * 从设计角度讲：抽象类是从子类中发先共有的东西，泛化出父类，然后子类继承父类，  而接口是压根不知道有子类，方法如何实现还不确定，进行的预定义。
 */
public class SimPleFactoryMain {


    public static void main(String[] args) {

        String animal = "cat";

        Animal animal1 = AnimalFactory.creatAnimal(animal);
        animal1.call();
        animal1.AddWeapon();
    }
}
