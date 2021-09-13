package com.testPackage.threadTest.AliTest.Order.Service;

import java.util.List;

/**
 * @author handy
 * @version 1.0
 * @date 2021/3/20 20:30
 */
public interface OrderService {
    /**
     * 下单接口
     */
    void addOrder();

    /**
     * 查询错误订单信息
     */
    List loadErrorOrder();
}
