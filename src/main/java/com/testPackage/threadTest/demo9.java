package com.testPackage.threadTest;

/**
 * @author handy
 * @version 1.0
 * 通过自旋的方式进行  交替打印
 * @date 2021/9/13 20:53
 */
public class demo9 {

    enum ReadyToRun {T1, T2}

    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {


        char[] ai = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();


        new Thread(() -> {

            for (int i = 0; i < ai.length; i++) {
                while (r != ReadyToRun.T1) {
                }
                System.out.println(ai[i]);
                r = ReadyToRun.T2;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < ac.length; i++) {
                while (r != ReadyToRun.T2) {}
                System.out.println(ac[i]);
                r = ReadyToRun.T1;
            }

        }).start();


    }
}
