package com.testPackage.threadTest;

public class demo3   {
    //    private Object object1 = new Object();
//如果不给其加锁的话他们会同时跑
    public  void test(){
        synchronized (this){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        demo3 demo3 = new demo3();
        //作用域符号”::“的前面一般是类名称，后面一般是该类的成员名称，C++为例避免不同的类有名称相同的成员而采用作用域的方式进行区分。
        //在这是没有实现Runnable 接口
        new Thread(demo3::test).start();
        new Thread(demo3::test).start();


//        new Thread(demo3).start();
//        new Thread(demo3).start();
    }


    //这块如果实现了implements Runnable  可以重写Run方法  和上面的  new Thread(demo3::test).start();  实现方法是一样的
//    @Override
//    public void run() {
//        synchronized (this){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName());
//        }
//    }
}
