package com.testPackage.designMode29.build;

/**
 * @Author handy
 * @Date 2021/5/18 下午4:11
 * @Version 1.0
 * 具体建造类
 */
public class ConcreteBuilder2 extends Builder {

    private Product product = new Product();


    @Override
    public void BuildPartA() {
        product.Add("部件X");
    }

    @Override
    public void BuildPartB() {
        product.Add("部件Y");
    }

    @Override
    public Product GetResult() {
        return product;
    }
}
