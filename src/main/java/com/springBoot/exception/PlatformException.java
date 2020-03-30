package com.springBoot.exception;

import com.springBoot.core.locale.MessageLocator;
import com.springBoot.filter.JepaasSessionFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class PlatformException extends RuntimeException {
    private String code;
    private String errorCode;
    private String errorMsg;
    private Object[] errorParam;

    public PlatformException() {
        super();
    }

    public PlatformException(Throwable cause) {
        super(cause);
    }

    public PlatformException(String message, ExceptionEnum exceptionEnum) {
        super(message);
        this.errorCode = ExceptionEnum.getDefault(exceptionEnum).getCode();
        this.errorMsg = MessageLocator.getMessage(this.errorCode, message);
    }

    public PlatformException(String message, ExceptionEnum exceptionEnum, Throwable cause) {
        super(message, cause);
        this.code = ExceptionEnum.getDefault(exceptionEnum).toString();
        this.errorCode = ExceptionEnum.getDefault(exceptionEnum).getCode();
        this.errorMsg = MessageLocator.getMessage(this.errorCode, message);
    }

    public PlatformException(String message, ExceptionEnum exceptionEnum, Object[] params) {
        super(message);
        this.code = ExceptionEnum.getDefault(exceptionEnum).toString();
        this.errorCode = ExceptionEnum.getDefault(exceptionEnum).getCode();
        this.errorMsg = MessageLocator.getMessage(this.errorCode, params, message);
    }

    public PlatformException(String message, ExceptionEnum exceptionEnum, Object[] params, Throwable cause) {
        super(message, cause);
        this.code = ExceptionEnum.getDefault(exceptionEnum).toString();
        this.errorCode = ExceptionEnum.getDefault(exceptionEnum).getCode();
        this.errorMsg = MessageLocator.getMessage(this.errorCode, params, message);
        this.errorParam = params;
    }

    public PlatformException(String message, ExceptionEnum exceptionEnum, HttpServletRequest request) {
        this(message, exceptionEnum, request, null);
    }

    public PlatformException(String message, ExceptionEnum exceptionEnum, HttpServletRequest request, Throwable cause) {
        super(message, cause);
        Map<String, Object> params = new HashMap<>();
        Enumeration<String> enumerations = request.getParameterNames();
        while (enumerations.hasMoreElements()) {
            String key = enumerations.nextElement();
            params.put(key, request.getParameter(key));
        }
        String uri = request.getRequestURI();
        Enumeration<String> enumeration = request.getHeaders(JepaasSessionFilter.X_AUTH_TOKEN);
        String tokenId = "";
        if (enumeration.hasMoreElements()) {
            tokenId = enumeration.nextElement();
        }
        this.code = ExceptionEnum.getDefault(exceptionEnum).toString();
        this.errorCode = ExceptionEnum.getDefault(exceptionEnum).getCode();
        this.errorMsg = MessageLocator.getMessage(this.errorCode, new Object[]{uri, tokenId, params}, message);
        this.errorParam = new Object[]{uri, tokenId, params};
    }

    @Override
    public String getLocalizedMessage() {
        return errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Object[] getErrorParam() {
        return errorParam;
    }

    public String getCode() {
        return code;
    }
}
