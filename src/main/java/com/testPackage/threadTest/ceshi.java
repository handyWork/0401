package com.testPackage.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author handy
 * @version 1.0
 * @date 2021/3/18 20:58
 */
public class ceshi extends Thread {

    private void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.shutdown();


    }

    @Override
    public void run() {
//        super.run();
    while (!isInterrupted()){
        try {
            ceshi.sleep(5555);
        } catch (InterruptedException e) {
            e.printStackTrace();
            break;
        }
    }


    }
}
