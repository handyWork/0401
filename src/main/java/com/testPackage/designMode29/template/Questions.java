package com.testPackage.designMode29.template;

/**
 * @Author handy
 * @Date 2021/5/18 下午1:59
 * @Version 1.0
 */
public abstract class Questions {

    public void testQuestion1() {
        System.out.println("26个字母中的第一个字母是什么？A:a,B:v,C:q,D:d");
        System.out.println("答案：" + answer1() + "");
    }

    public void testQuestion2() {
        System.out.println("小猫是动物么？A:是,B:不是");
        System.out.println("答案：" + answer2() + "");
    }

    public void testQuestion3() {
        System.out.println("苹果是蔬菜么？A:是,B:不是");
        System.out.println("答案：" + answer3() + "");
    }

    public String answer1() {
        return "";
    }

    public String answer2() {
        return "";
    }

    public String answer3() {
        return "";
    }


}

