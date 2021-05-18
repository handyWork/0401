package com.testPackage.designMode29.build;

/**
 * @Author handy
 * @Date 2021/5/18 下午4:18
 * @Version 1.0
 * 建造者模式测试
 * 作用： 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示
 */
public class BuilderMain {
    public static void main(String[] args) {
        ConcreteBuilder b1 = new ConcreteBuilder();
        ConcreteBuilder2 b2 = new ConcreteBuilder2();

        Director director = new Director();
        director.Construtct(b1);
        Product p1 = b1.GetResult();
        p1.show();


        director.Construtct(b2);
        Product p2 = b2.GetResult();
        p2.show();


    }
}
