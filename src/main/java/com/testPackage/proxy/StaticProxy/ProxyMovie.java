package com.testPackage.proxy.StaticProxy;

/**
 * 代理类
 */
public class ProxyMovie implements Movie{

    RealMovie realMovie;

    public ProxyMovie(RealMovie realMovie) {
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        System.out.println("网剧开始前吃点水果。");
        realMovie.play();
        System.out.println("网剧结束后，打扫卫生。");
    }
}
