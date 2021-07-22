package com.springBoot.utils;

/**
 * @Author handy
 * @Date 2021/7/5 下午4:41
 * @Version 1.0
 */
public enum  ResultCode {
    SUCCESS("200","成功"),
    ERROR("9999","失败,请联系管理员")
    ;
    private String code;
    private String value;

    ResultCode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
