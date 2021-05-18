package com.testPackage.designMode29.build;

/**
 * @Author handy
 * @Date 2021/5/18 下午4:15
 * @Version 1.0
 * 指挥者类
 */
public class Director {

    public void Construtct(Builder builder) {
        builder.BuildPartA();
        builder.BuildPartB();
    }

}
