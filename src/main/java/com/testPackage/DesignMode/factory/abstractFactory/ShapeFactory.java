package com.testPackage.DesignMode.factory.abstractFactory;

import org.thymeleaf.util.StringUtils;

/**
 * 创建扩展了AbstractFactory 的扩展类，基于给定的信息生成实体类对象
 */
public class ShapeFactory extends AbstractFactory {


    @Override
    public Shape getShape(String shape) {

        if (StringUtils.isEmpty(shape)) {
            return null;
        }

        if ("RECTANGLE".equalsIgnoreCase(shape)) {
            return new Rectangle();
        }

        if ("SQUARE".equalsIgnoreCase(shape)) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {

        if (StringUtils.isEmpty(color)) {
            return null;
        }


        return null;
    }


}
