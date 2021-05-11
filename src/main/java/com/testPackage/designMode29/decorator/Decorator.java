package com.testPackage.designMode29.decorator;

/**
 * 装饰角色
 */
public class Decorator implements Component {
    private Component component; // 持有component类型的对象引用

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void function() {
        component.function();// 客户端的调用委派给具体的子类
    }
}
