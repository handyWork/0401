package com.testPackage.designMode29.factory;

/**
 * 学习雷锋的工厂
 */
public class XueLeiFengFactory extends Ifactory {
    @Override
    Leifeng creatLeifeng() {
        return new Leifeng();
    }
}
