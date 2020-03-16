//package com.testPackage.pay.vo;
//
//import com.je.core.util.JEUUID;
//import com.je.core.util.StringUtil;
//import com.je.core.util.WebUtils;
//import org.springframework.security.providers.encoding.Md5PasswordEncoder;
//
//import java.util.Arrays;
//
///**
// * TODO未处理
// */
//public class AppPay {
//	//屏蔽无参构造
//	@SuppressWarnings("unused")
//	private AppPay(){
//
//	}
//	/**
//	 * 构造订单信息
//	 * @param out_trade_no  商户订单号-必填 32位 ,自己系统内的
//	 * @param product_id 商品的ID
//	 * @param body 商品描述-必填
//	 * @param total_fee 总金额-必填
//	 */
//	public AppPay(String out_trade_no, String product_id, String body, int total_fee){
//		setOut_trade_no(out_trade_no);
//		setBody(this.body_name+""+body);
//		setTotal_fee(total_fee);
//		setProduct_id(product_id);
//	}
//	//微信申请APPID
//	private String appId="";
//	//微信支付签名
//	private String paySignKey="";
//	//商户ID
//	private String mch_id="1450522502";
//	//总金额-必填(分)
//	private int total_fee = 0;
//	/**
//	 * 通知地址-必填
//	 * 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
//	 * String(256)
//	 */
//	private String notify_url = "/je/pay/payOrder/payCallBack";
//	//随机数-必填
//	private String nonce_str = JEUUID.uuid();
//	private String body_name;
//	//商品描述-必填
//	private String body = null;
//	//附件数据-不必填
//	private String attach = "JEPAAS";
//	//商户订单号-必填 32位
//	private String out_trade_no = null;
//	//用户终端ID-必填
//	private String spbill_create_ip = "";
//	//交易类型-必填 JAPP、JSAPI--公众号支付、NATIVE--原生扫码支付
//	private String trade_type = "APP";
//	//产品ID 用户自定义
//	private String product_id = null;
//
//	//签名-必填
//	private String sign = null;
//
//	/**
//	 * 初始化配置
//	 */
//	public void init(){
//		this.appId=WebUtils.getSysVar("WX_KFPT_APPID");
//		this.paySignKey=WebUtils.getSysVar("WX_KFPT_APPSECRET");
//		this.mch_id=WebUtils.getSysVar("WX_APP_MCH_ID");
//		this.attach=WebUtils.getSysVar("WX_APP_ATTACH");
//		this.body_name=WebUtils.getSysVar("WX_APP_BODY_NAME");
//		this.spbill_create_ip=WebUtils.getSysVar("WX_APP_SPBILL_CREATE_IP");
//		this.notify_url=WebUtils.getSysVar("WX_APP_NOTIFY_URL");
//		this.trade_type=StringUtil.getDefaultValue(WebUtils.getSysVar("WX_APP_TRADE_TYPE"),"APP");
//	}
//	/**
//	 * 检测支付参数
//	 * @return
//	 */
//	public String checkPay(){
//		String errors="";
//		if(StringUtil.isEmpty(this.appId) || StringUtil.isEmpty(this.paySignKey)){
//			errors="APP配置信息有误，请配置正确的微信开放平台配置!";
//			return errors;
//		}
//		if(StringUtil.isEmpty(this.mch_id) || StringUtil.isEmpty(this.spbill_create_ip) || StringUtil.isEmpty(this.notify_url)){
//			errors="微信App端支付参数设置有误，请配置正确的参数!";
//		}
//		return errors;
//	}
//	/**
//	 * 得到生成订单需要用的xml
//	 * @return
//	 */
//	public String getPaySendInfo4Xml(){
//		StringBuffer xml = new StringBuffer();
//		xml.append("<xml>");
//		xml.append("<appid>"+appId+"</appid>"); //1
//		xml.append("<mch_id>"+mch_id+"</mch_id>");//3.5
//		xml.append("<nonce_str>"+nonce_str+"</nonce_str>");//4
//		xml.append("<sign>"+getSign()+"</sign>");//8
//		xml.append("<body>"+getBody()+"</body>");//3
//		xml.append("<attach>"+getAttach()+"</attach>");	//2
//		xml.append("<out_trade_no>"+getOut_trade_no()+"</out_trade_no>");//7
//		xml.append("<total_fee>"+getTotal_fee()+"</total_fee>");//10
//		xml.append("<spbill_create_ip>"+getSpbill_create_ip()+"</spbill_create_ip>");//9
//		xml.append("<notify_url>"+getNotify_url()+"</notify_url>");//5
//		xml.append("<trade_type>"+getTrade_type()+"</trade_type>");//11
//		xml.append("<product_id>"+getProduct_id()+"</product_id>");//11
//		xml.append("</xml>");
//		return xml.toString();
//	}
//	@Override
//	public String toString() {
//		return getPaySendInfo4Xml();
//	}
//	public String getNonce_str() {
//		return nonce_str;
//	}
//	public void setNonce_str(String nonce_str) {
//		this.nonce_str = nonce_str;
//	}
//	public String getSign() {
//		/**
//		 * 第一步，设所有发送或者接收到的数据为集合M，将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），
//		 * 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串stringA。
//		 */
//		String[] str = {
//				"appid="+appId,
//				"mch_id="+mch_id,
//				"nonce_str="+nonce_str,
//				"body="+getBody(),
//				"attach="+getAttach(),
//				"out_trade_no="+getOut_trade_no(),
//				"total_fee="+getTotal_fee(),
//				"spbill_create_ip="+getSpbill_create_ip(),
//				"notify_url="+getNotify_url(),
//				"trade_type="+getTrade_type(),
//				"product_id="+getProduct_id()
//		};
//		Arrays.sort(str);
//		StringBuffer stringA = new StringBuffer();;
//		for (String string : str) {
//			stringA.append(string+"&");
//		}
//		//第二步：拼接API密钥：
//		String stringSignTemp = stringA.toString()+"key="+paySignKey;
//		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//		this.sign = md5.encodePassword(stringSignTemp,null).toUpperCase();
//		return this.sign;
//	}
//	public void setSign(String sign) {
//		this.sign = sign;
//	}
//	public String getBody() {
//		return body;
//	}
//	public void setBody(String body) {
//		this.body = body;
//	}
//	public String getOut_trade_no() {
//		return out_trade_no;
//	}
//	public void setOut_trade_no(String out_trade_no) {
//		this.out_trade_no = out_trade_no;
//	}
//	public int getTotal_fee() {
//		return total_fee;
//	}
//	public void setTotal_fee(int total_fee) {
//		this.total_fee = total_fee;
//	}
//	public String getSpbill_create_ip() {
//		return spbill_create_ip;
//	}
//	public void setSpbill_create_ip(String spbill_create_ip) {
//		this.spbill_create_ip = spbill_create_ip;
//	}
//	public String getNotify_url() {
//		return notify_url;
//	}
//	public void setNotify_url(String notify_url) {
//		this.notify_url = notify_url;
//	}
//	public String getTrade_type() {
//		return trade_type;
//	}
//	public void setTrade_type(String trade_type) {
//		this.trade_type = trade_type;
//	}
//	public String getAttach() {
//		return attach;
//	}
//	public String getProduct_id() {
//		return product_id;
//	}
//	public void setProduct_id(String product_id) {
//		this.product_id = product_id;
//	}
//	public String getAppId() {
//		return appId;
//	}
//	public void setAppId(String appId) {
//		this.appId = appId;
//	}
//	public String getPaySignKey() {
//		return paySignKey;
//	}
//	public void setPaySignKey(String paySignKey) {
//		this.paySignKey = paySignKey;
//	}
//	public String getMch_id() {
//		return mch_id;
//	}
//	public void setMch_id(String mch_id) {
//		this.mch_id = mch_id;
//	}
//	public String getBody_name() {
//		return body_name;
//	}
//	public void setBody_name(String body_name) {
//		this.body_name = body_name;
//	}
//	public void setAttach(String attach) {
//		this.attach = attach;
//	}
//
//}
