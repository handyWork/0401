package com.testPackage.proxy.StaticProxy;

/**
 * 真实类（目标类）
 */
public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("您正在播放网剧《大神猴》");
    }
}
