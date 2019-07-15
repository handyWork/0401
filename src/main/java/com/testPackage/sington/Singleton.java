package com.testPackage.sington;

/**
 * 单例模式之饿汉
 * author:yangzhi
 * Date:2018/7/11
 * Time:18:14
 */
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton(){
        //do something
    }
    //这里提供了一个供外部访问本class的静态方法，可以直接访问
    public static Singleton getInstance(){
        return instance;
    }

}

//    懒汉模式，它的特点是运行时获得对象的速度比较慢，但加载类的时候比较快。它在整个应用的生命周期只有一部分时间在占用资源。
//    饿汉模式，它的特点是加载类的时候比较慢，但运行时获得对象的速度比较快。它从加载到应用结束会一直占用资源。
//    这两种模式对于初始化较快，占用资源少的轻量级对象来说，没有多大的性能差异，选择懒汉式还是饿汉式都没有问题。但是对于初始化慢，占用资源多的重量级对象来说，就会有比较明显的差别了。所以，对重量级对象应用饿汉模式，类加载时速度慢，但运行时速度快；懒汉模式则与之相反，类加载时速度快，但运行时第一次获得对象的速度慢。
//    从用户体验的角度来说，我们应该首选饿汉模式。我们愿意等待某个程序花较长的时间初始化，却不喜欢在程序运行时等待太久，给人一种反应迟钝的感觉，所以对于有重量级对象参与的单例模式，我们推荐使用饿汉模式。
//    而对于初始化较快的轻量级对象来说，选用哪种方法都可以。如果一个应用中使用了大量单例模式，我们就应该权衡两种方法了。轻量级对象的单例采用懒汉模式，减轻加载时的负担，缩短加载时间，提高加载效率；同时由于是轻量级对象，把这些对象的创建放在使用时进行，实际就是把创建单例对象所消耗的时间分摊到整个应用中去了，对于整个应用的运行效率没有太大影响。