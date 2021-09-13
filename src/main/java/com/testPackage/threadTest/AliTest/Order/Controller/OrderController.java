package com.testPackage.threadTest.AliTest.Order.Controller;

import cn.hutool.db.sql.Order;
import com.springBoot.core.base.MethodArgument;
import com.testPackage.threadTest.AliTest.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author handy
 * @version 1.0
 * @date 2021/3/20 20:22
 */
@Controller
@RequestMapping(value = "/je/ali/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public void getInfoById(MethodArgument param) {
        orderService.addOrder();

    }

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 1;
        int aint = a.intValue();
        int bint = b.intValue();
        System.out.println(aint == bint);

        System.out.println(a==b);

    }


}
