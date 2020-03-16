//package com.testPackage.pay.service;
//
//import com.google.common.base.Strings;
//import com.je.core.exception.PlatformException;
//import com.je.core.exception.PlatformExceptionEnum;
//import com.je.core.util.*;
//import com.je.paas.document.model.bean.FileUpload;
//import com.je.paas.document.model.bo.FileBO;
//import com.je.paas.document.service.DocumentBusService;
//import com.je.pay.vo.Pay;
//import com.je.shoppingmall.BillCode;
//import com.testPackage.pay.vo.Pay;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
///**
// * @program: je-platform
// * @author: LIULJ
// * @create: 2020-03-14 11:20
// * @description: 微信支付接口实现
// */
//@Service("wechatPaymentService")
//public class WechatPaymentServiceImpl implements PaymentService {
//
//    private static final Logger logger = LoggerFactory.getLogger(WechatPaymentServiceImpl.class);
//
//    @Autowired
//    private DocumentBusService documentBusService;
//
//    /**
//     * 微信统一支付URL
//     */
//    private static final String WECHAT_UNIFIED_PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//
//    @Override
//    public boolean placeOrderWithDirect(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl) {
//        throw new PlatformException("微信支付暂时不支持直接扣款支付", PlatformExceptionEnum.PAY_FAIL);
//    }
//
//    @Override
//    public FileBO placeOrderWithQRCode(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl) {
//
//        if (Strings.isNullOrEmpty(orderName)) {
//            logger.error("支付名称不能为空！");
//            throw new PlatformException("支付名称不能为空！", PlatformExceptionEnum.PAY_FAIL);
//        }
//
//        if (Strings.isNullOrEmpty(busType)) {
//            logger.error("支付业务名称不能为空！");
//            throw new PlatformException("支付业务名称不能为空！", PlatformExceptionEnum.PAY_FAIL);
//        }
//
//        if (amount <= 0) {
//            logger.error("\"订单金额必须大于0，当前为{}", amount);
//            throw new PlatformException("订单金额必须大于0！", PlatformExceptionEnum.PAY_FAIL);
//        }
//        logger.warn("开始生成支付二维码,{},{},{},{},{}", orderName, busType, serialNo, orderId, amount);
//        //生成支付名称
//        String payName = String.format("%s-%s", orderName, busType);
//
//        //计算超时时间
//        Calendar now = Calendar.getInstance();
//        now.add(Calendar.MINUTE, DEFAULT_TIMEOUT_MINUTES_INTERVAL);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String timeout = sdf.format(now.getTime());
//
//        double payment = MathExtend.multiply(amount, 100);
//        int paymentAmout = Integer.parseInt(new java.text.DecimalFormat("0").format(payment));
//
//        //构建支付对象，调用支付接口
//        Pay pay = new Pay(serialNo, orderId, payName, paymentAmout, timeout, callbackUrl, "PC");
//        logger.warn("开始调用微信二维码接口，{}", pay);
//        String resData = JavaAjaxUtil.sendPost4Xml(WECHAT_UNIFIED_PAY_URL, pay.toString());
//        Document doc = null;
//        try {
//            doc = DocumentHelper.parseText(resData);
//        } catch (DocumentException e) {
//            logger.error(e.getMessage());
//            throw new PlatformException("出错原因：" + e.getMessage() + "|,出错编码：" + BillCode.PAY_FAIL_2002, PlatformExceptionEnum.JE_SAAS_PAY_ERROR, e);
//        }
//
//        //解析结果，调用成功，返回二维码文件信息，调用失败抛出异常
//        Element root = doc.getRootElement();
//        // 通信标识
//        String returnCode = root.element("return_code").getText();
//        // 下单业务结果
//        String returnMsg = root.element("return_msg").getText();
//        String resultCode = root.element("result_code").getText();
//
//        if (!returnCode.equals("SUCCESS") || !returnMsg.equals("OK") || !resultCode.equals("SUCCESS")) {
//            logger.warn("调用微信二维码接口失败，message:{},code:{},resultCode:{}", returnCode, returnMsg, resultCode);
//            throw new PlatformException(String.format("用户使用微信进行余额充值失败！{},{},{},{},{}", orderName, busType, serialNo, orderId, amount), PlatformExceptionEnum.JE_SAAS_PAY_ERROR);
//        }
//
//        logger.warn("调用微信二维码接口成功，开始生成二维码！message:{},code:{},resultCode:{}", returnCode, returnMsg, resultCode);
//        String payUrl = root.element("code_url").getText();
//        QRCodeEntity qrcode = new QRCodeEntity();
//        qrcode.setContent(payUrl);
//        qrcode.setWidth(200);
//        qrcode.setHeight(200);
//        qrcode.setVersion(12); // 控制版本
//        qrcode.setQrcodeErrorCorrect('Q'); //控制容错率
//        qrcode.setFormat("png");
//        ByteArrayOutputStream os = QRCodeUtil.createOutputStreamQRCode(qrcode);
//        logger.warn("生成二维码成功！开始上传二维码至存储桶！");
//        String fileKey = JEUUID.uuid();
//        String fileName = String.format("%s-%s.png", payName, serialNo);
//        FileUpload fileUpload = new FileUpload(fileKey, fileName, "", (long) os.size(), new ByteArrayInputStream(os.toByteArray()));
//        FileBO fileBO = documentBusService.saveSingleFile(fileUpload, SecurityUserHolder.getCurrentUser().getUserId());
//        logger.warn("上传二维码至存储桶成功！{}", fileBO);
//        return fileBO;
//    }
//
//    @Override
//    public String placeOrderWithHtml(String orderName, String busType, String serialNo, String orderId, double amount, String callbackUrl) {
//        throw new PlatformException("微信支付暂时不支持网页支付", PlatformExceptionEnum.PAY_FAIL);
//    }
//}
