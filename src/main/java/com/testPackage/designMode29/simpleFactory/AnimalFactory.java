package com.testPackage.designMode29.simpleFactory;

/**
 * 创建动物工厂
 */
public class AnimalFactory {
    public static Animal creatAnimal(String animal) {

        Animal animal1 = null;

        switch (animal) {
            case "cat":
                animal1 = new Cat(animal);
                break;
            case "dog":
                animal1 = new Dog(animal);
                break;
        }
        return animal1;
    }
}
