package com.testPackage.responsibility;

/**
 * 构建一个责任链模式
 * 建立这个接口时为了把  要处理一件事情时，在责任链中的每个节点中谁可以处理的方法写在operator（）的实现中；
 */
public interface Handler {
    void operator();
}
