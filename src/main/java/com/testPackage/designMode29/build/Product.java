package com.testPackage.designMode29.build;

import java.util.ArrayList;

/**
 * @Author handy
 * @Date 2021/5/18 下午4:03
 * @Version 1.0
 * 产品bean
 */
public class Product {

    private ArrayList<String> list = new ArrayList<String>();
    
    public void Add(String part) {
        list.add(part);
    }
    public  void  show(){
        for (String s : list) {
            System.out.println(s);
        }
    }
}
