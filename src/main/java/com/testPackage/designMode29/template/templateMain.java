package com.testPackage.designMode29.template;

/**
 * @Author handy
 * @Date 2021/5/18 下午2:09
 * @Version 1.0
 * 模板方法测试  （）
 */
public class templateMain {

    public static void main(String[] args) {
        System.out.println("PersonA的试卷------------");
        PersonA personA = new PersonA();
        personA.testQuestion1();
        personA.testQuestion2();
        personA.testQuestion3();


        System.out.println("PersonB的试卷-------------");
        PersonB personB = new PersonB();
        personB.testQuestion1();
        personB.testQuestion2();
        personB.testQuestion3();

    }
}
