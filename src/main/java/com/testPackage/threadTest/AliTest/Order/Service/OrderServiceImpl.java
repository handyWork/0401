package com.testPackage.threadTest.AliTest.Order.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author handy
 * @version 1.0
 * @date 2021/3/20 20:31
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Override
    public void addOrder() {

        // 1.  将下单数据插入到本地数据库中

        // 2. 将下单数据推送到物流系统中  通过httpClient进行推送

        // 3. 通过判断返回的状态是否成功，没成功的话 把当前的订单信息放入到错误订单表中


    }

    @Override
    public List loadErrorOrder() {

        ArrayList<Object> lists = new ArrayList<>();
        // 给error_order  添加INDEX 索引   列上只查 想要的字段  加快查询

        // SELECT orderId FROM je_core_error_order WHERE error_order = "1"

        return lists;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "123";
            }
        });
    }

}


