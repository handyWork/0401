package com.testPackage.abstractTest;

import com.note.enumerate.SeasonEnum;
import com.note.sington.SingletonClass;

public class mainTest {

    public static void dothing(test a){
        a.doing();
    }
    public void handle(test2 b){
        b.testDoing();
    }


    public static void main(String[] args) {
//        mainTest mainTest = new mainTest();
//        test duck = new test("a","b");
//        duck.eat();
//        mainTest.dothing(duck);
//        String name = duck.getName();
//        System.out.println(name);
        int seq = SeasonEnum.AUTUMN.getSeq();
        String value = SeasonEnum.AUTUMN.getValue();
        System.out.println(seq);
        System.out.println(value);
    }
}
