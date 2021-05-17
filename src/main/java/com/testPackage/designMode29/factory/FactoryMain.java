package com.testPackage.designMode29.factory;

/**
 * 工厂模式测试   （简单工厂 和 工厂模式 有所区别）
 */
public class FactoryMain {
    public static void main(String[] args) {
//        XueLeiFengFactory factory = new XueLeiFengFactory();
        ZhiYuanZheFactory factory = new ZhiYuanZheFactory();

        Leifeng leifeng = factory.creatLeifeng();

        leifeng.saodi();
        leifeng.xiyi();
        leifeng.zuofan();
//        leifeng.shuomei();


    }
}
