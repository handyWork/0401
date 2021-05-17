package com.testPackage.designMode29.factory;

/**
 * 志愿者工厂
 */
public class ZhiYuanZheFactory extends Ifactory {

    @Override
    Leifeng creatLeifeng() {
        return new ZhiYuanZhe();
    }
}
