package com.testPackage.proxy;

/**
 * 定义一个检测方法执行时间的工具
 */
public  class MonitorUtil {

    private static ThreadLocal<Long> t1 = new ThreadLocal();

    public static  void start() {
        t1.set(System.currentTimeMillis());
    }

    public static  void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "耗费的时间是" + (finishTime - t1.get()) + "ms");

    }

}
