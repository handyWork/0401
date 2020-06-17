package com.testPackage.proxy.StaticProxy;

/**
 * 静态代理测试
 */
public class StaticTest {

    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        ProxyMovie proxyMovie = new ProxyMovie(realMovie);
        proxyMovie.play();
    }
}
