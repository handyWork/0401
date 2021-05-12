package com.testPackage.designMode29.proxy.test1;

import com.testPackage.designMode29.proxy.test1.IRunner;

public class Runner implements IRunner {
    @Override
    public void run() {
        System.out.println("运动员正在跑步");
    }
}
