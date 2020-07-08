package com.testPackage.DesignMode.factory.abstractFactory;

import org.thymeleaf.util.StringUtils;

/**
 * 创建扩展了AbstractFactory 的扩展类，基于给定的信息生成实体类对象
 */
public class ColorFactory extends AbstractFactory {


    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {

        if (StringUtils.isEmpty(color)) {
            return null;
        }

        if ("red".equalsIgnoreCase(color)) {
            return new Red();
        }

        if ("green".equalsIgnoreCase(color)) {
            return new Green();
        }
        return null;
    }


}
