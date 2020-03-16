//package com.testPackage.pay.service;
//
//import com.je.paas.document.model.bo.FileBO;
//
///**
// * @program: je-platform
// * @author: LIULJ
// * @create: 2020-03-14 10:51
// * @description: 重写支付接口，抽象出各种支付，禁止把各种支付混合到一起！！！！
// */
//public interface PaymentService {
//
//    /**
//     * 默认超时时间是30分钟
//     */
//    int DEFAULT_TIMEOUT_MINUTES_INTERVAL = 30;
//
//    /**
//     * 直接扣款支付
//     * @param orderName
//     * @param busType
//     * @param serialNo
//     * @param orderId
//     * @param amount
//     * @param callbackUrl
//     * @return
//     */
//    boolean placeOrderWithDirect(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl);
//
//    /**
//     * 二维码支付，向第三方支付下单并生成二维码
//     * @param orderName 支付的订单名称，如"蒜瓣商城"
//     * @param busType 支付业务类型，如"蒜瓣余额充值"
//     * @param serialNo 订单号
//     * @param orderId 订单ID
//     * @param amount 下单的金额
//     * @param callbackUrl 回调的接口
//     * @return 二维码文件
//     */
//    FileBO placeOrderWithQRCode(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl);
//
//    /**
//     * 网页支付，向第三方支付下单并生成二维码
//     * @param orderName 支付的订单名称，如"蒜瓣商城"
//     * @param busType 支付业务类型，如"蒜瓣余额充值"
//     * @param serialNo 订单号
//     * @param orderId 订单ID
//     * @param amount 下单的金额
//     * @param callbackUrl 回调的接口
//     * @return 支付服务返回的html
//     */
//    String placeOrderWithHtml(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl);
//
//
//}
