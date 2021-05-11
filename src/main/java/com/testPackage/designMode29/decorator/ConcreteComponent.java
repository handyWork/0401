package com.testPackage.designMode29.decorator;

/**
 * 具体构建角色（对应狗）
 */
public class ConcreteComponent implements Component {

    @Override
    public void function() {
        System.out.println("基本功能：呼吸+觅食+睡觉");
    }
}
