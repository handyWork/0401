package com.testPackage.spring.ioc;

import org.junit.Test;

public class SimpleIocTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIoc.class.getClassLoader().getResource("spring-ioc.xml").getFile();
        SimpleIoc simpleIoc = new SimpleIoc(location);

        Wheel wheel = (Wheel) simpleIoc.getBean("wheel");
        System.out.println(wheel);

        Car car = (Car) simpleIoc.getBean("car");
        System.out.println(car.getHeight());
    }
}
