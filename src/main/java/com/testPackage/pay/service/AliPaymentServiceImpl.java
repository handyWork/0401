//package com.testPackage.pay.service;
//
//import com.alipay.config.AlipayConfig;
//import com.alipay.util.AlipaySubmit;
//import com.google.common.base.Strings;
//import com.je.core.exception.PlatformException;
//import com.je.core.exception.PlatformExceptionEnum;
//import com.je.paas.document.model.bo.FileBO;
//import com.je.paas.document.service.DocumentBusService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @program: je-platform
// * @author: LIULJ
// * @create: 2020-03-14 11:41
// * @description: 支付宝支付接口实现
// */
//@Service("aliPaymentService")
//public class AliPaymentServiceImpl implements PaymentService {
//
//    private static final Logger logger = LoggerFactory.getLogger(AliPaymentServiceImpl.class);
//
//    @Autowired
//    private DocumentBusService documentBusService;
//
//    @Override
//    public boolean placeOrderWithDirect(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl) {
//        throw new PlatformException("支付宝支付暂时不支持直接扣款支付",PlatformExceptionEnum.PAY_FAIL);
//    }
//
//    @Override
//    public FileBO placeOrderWithQRCode(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl) {
//        throw new PlatformException("支付宝支付暂时不支持二维码支付",PlatformExceptionEnum.PAY_FAIL);
//    }
//
//    @Override
//    public String placeOrderWithHtml(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl) {
//
//        if(Strings.isNullOrEmpty(orderName)){
//            logger.error("支付名称不能为空！");
//            throw new PlatformException("支付名称不能为空！",PlatformExceptionEnum.PAY_FAIL);
//        }
//
//        if(Strings.isNullOrEmpty(busType)){
//            logger.error("支付业务名称不能为空！");
//            throw new PlatformException("支付业务名称不能为空！",PlatformExceptionEnum.PAY_FAIL);
//        }
//
//        if(amount <= 0){
//            logger.error("\"订单金额必须大于0，当前为{}",amount);
//            throw new PlatformException("订单金额必须大于0！",PlatformExceptionEnum.PAY_FAIL);
//        }
//
//        //进行Ali支付配置初始化
//        if (!AlipayConfig.init) {
//            logger.warn("开始进行支付宝配置初始化！");
//            AlipayConfig.pcInit();
//            logger.warn("支付宝配置初始化完成！");
//        }
//        logger.warn("开始构建支付参数");
//        //生成支付名称
//        String payName = String.format("%s-%s",orderName,busType);
//        String timeout = DEFAULT_TIMEOUT_MINUTES_INTERVAL+"m";
//        Map<String, String> sParaTemp = new HashMap<String, String>();
//        sParaTemp.put("service", AlipayConfig.service);
//        sParaTemp.put("partner", AlipayConfig.partner);
//        sParaTemp.put("seller_id", AlipayConfig.seller_id);
//        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
//        sParaTemp.put("payment_type", AlipayConfig.payment_type);
//        sParaTemp.put("notify_url", callbackUrl);
//        sParaTemp.put("return_url", "");
//        sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
//        sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
//        sParaTemp.put("out_trade_no", serialNo);
//        sParaTemp.put("subject", payName);
//        sParaTemp.put("total_fee", amount + "");
//        sParaTemp.put("it_b_pay", timeout);
//        sParaTemp.put("body", payName);
//        logger.warn("构建支付参数成功，开始调用网页支付接口！");
//        //建立请求
//        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
//        logger.warn("调用支付接口成功，返回Html!");
//        return sHtmlText;
//    }
//}
