package com.springBoot.result;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

public class BaseRespResult<T> implements Serializable {
    private static final long serialVersionUID = -4507574037830481719L;

    private static final String OK_CODE = "1000";
    private static final String OK_MESSAGE = "操作成功";

    boolean success;
    private String type;
    private String code;
    private String errorCode;
    private String message;
    private String exceptionId;
    private T obj;

    /**
     * 分页-数据
     */
    private List rows;
    /**
     * 分页-总条数
     */
    private Long totalCount;

    public BaseRespResult() {
    }


    public BaseRespResult(boolean success, T obj, String code, String message, String errorCode, String exceptionId) {
        this.success = success;
        this.obj = obj;
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }

    public BaseRespResult(boolean success, String type, T obj, String code, String message, String errorCode, String exceptionId) {
        this.success = success;
        this.type = type;
        this.obj = obj;
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }


    public static BaseRespResult errorResult(String obj) {
        return errorResult("200", obj);
    }

    public static BaseRespResult errorResult(String code, String obj) {
        return new BaseRespResult(false, obj, code, obj, "", "");
    }

    public static BaseRespResult errorResult(String code, String errorCode, String message) {
        return new BaseRespResult(false, message, code, message, errorCode, "");
    }

    public static BaseRespResult errorResult(String code, String errorCode, Object obj) {
        return new BaseRespResult(false, obj, code, null, errorCode, "");
    }

    public static BaseRespResult errorResult(String code, String errorCode, String obj, String message) {
        return new BaseRespResult(false, obj, code, message, errorCode, "");
    }

    public static BaseRespResult errorResult(String code, String errorCode, Object obj, String message, String exceptionId) {
        return new BaseRespResult(false, obj, code, message, errorCode, exceptionId);
    }

    public static BaseRespResult successResult(Object obj) {
        return new BaseRespResult(true, obj, OK_CODE, OK_MESSAGE, "", "");
    }

    public static BaseRespResult successResult(Object obj, String message) {
        return new BaseRespResult(true, obj, OK_CODE, message, "", "");
    }

    public static BaseRespResult successResult(Object obj, String code, String message) {
        return new BaseRespResult(true, obj, code, message, "", "");
    }

    public static BaseRespResult successResult(String type, Object obj, String code, String message) {
        return new BaseRespResult(true, type, obj, code, message, "", "");
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
