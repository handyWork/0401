package com.springBoot.utils;

import java.io.Serializable;

/**
 * @Author handy
 * @Date 2021/7/5 下午4:37
 * @Version 1.0
 */
public class BaseResult  implements Serializable {

    private String code;
    private String message;
    private Object data;

    public static BaseResult success(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setMessage(ResultCode.SUCCESS.getValue());
        return  baseResult;
    }

    public static BaseResult error(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ResultCode.ERROR.getCode());
        baseResult.setMessage(ResultCode.ERROR.getValue());
        return  baseResult;
    }

    public static BaseResult success(String code, String message, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return  baseResult;
    }
    public static BaseResult success(Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ResultCode.SUCCESS.getCode());
        baseResult.setMessage(ResultCode.SUCCESS.getValue());
        baseResult.setData(data);
        return  baseResult;
    }

    public static BaseResult error(String code, String message, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return  baseResult;
    }

    public static BaseResult error(String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ResultCode.ERROR.getCode());
        baseResult.setMessage(message);
        return  baseResult;
    }

    public static BaseResult error(Object data){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ResultCode.ERROR.getCode());
        baseResult.setMessage(ResultCode.ERROR.getValue());
        baseResult.setData(data);
        return  baseResult;
    }



    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
