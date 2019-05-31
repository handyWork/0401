package com.springBoot.exception;

/**
 *   异常枚举类
 */
public enum ExceptionEnum {
//    ERROR_01("系统异常"),
//    ERROR_02("参数异常"),
//    ERROR_03("运行时异常"),
//    ERROR_04("数组下标越界异常");

    ERROR_01("1000"),
    ERROR_02("2000"),
    ERROR_03("3000"),
    ERROR_04("4000");

    private String code;

    ExceptionEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
