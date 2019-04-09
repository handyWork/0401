package com.note.sington;

/**
 * 单例模式之懒汉
 * author:yangzhi
 * Date:2018/7/11
 * Time:17:56
 */
public class SingletonClass {

    private static SingletonClass instance = null;
//    public static synchronized SingletonClass getInstance(){
//        if(instance == null) {
//                instance = new SingletonClass();
//        }
//        return  instance;
//    }

    // 这个是对多线程情况下的优化  详细见   https://www.cnblogs.com/geek6/p/3951677.html
    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

}
