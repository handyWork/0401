package com.note.sington;

/**
 * 单例模式之懒汉
 * author:yangzhi
 * Date:2018/7/11
 * Time:17:56
 */
public class SingletonClass {

    private static SingletonClass instance = null;
    public static synchronized SingletonClass getInstance(){
        if(instance == null) {
            instance = new SingletonClass();
        }
        return  instance;
    }

}
