package com.springBoot.jepaasEnum;

/**
 * jepaas商城枚举类
 */
public enum JepaasEnum {

    //已存在下单商品
    REPEAT_ORDER("100001"),
    // 没有白条权限
    WHITEBAR_AUTHORIZATION("100002"),
    // 白条账户不足
    INSUFFICIENT_ACCOUNT("100003"),
    //未知异常
    UNKOWN_ERROR("999999");

    private String code;

    JepaasEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
