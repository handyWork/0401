package com.testPackage.observerTest;

public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.opration();

//        Subject subject1 = new SubjectImpl();
//        subject1.add(new Observer1());
//        subject1.add(new Observer2());
//        subject1.opration();
    }
}
