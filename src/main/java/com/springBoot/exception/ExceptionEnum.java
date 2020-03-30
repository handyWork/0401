package com.springBoot.exception;

/**
 * 异常枚举类
 */
public enum ExceptionEnum {
//    ERROR_01("系统异常"),
//    ERROR_02("参数异常"),
//    ERROR_03("运行时异常"),
//    ERROR_04("数组下标越界异常");

    ERROR_01("1000"),
    ERROR_02("1001"),
    ERROR_03("1002"),
    JE_RBAC_FILTER_ERROR("1003"),
    UNKOWN_LOGINUSER("1004"),
    UNKOWN_ERROR("9999"),
    ERROR_04("4000");

    private String code;


    public static ExceptionEnum getDefault(ExceptionEnum exceptionEnum) {
        if (exceptionEnum == null) {
            return UNKOWN_ERROR;
        }

        for (ExceptionEnum value : ExceptionEnum.values()) {
            if (value.equals(exceptionEnum)) {
                return exceptionEnum;
            }
        }

        return UNKOWN_ERROR;
    }

    ExceptionEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
