package com.springBoot.exception;

public class StudyException extends RuntimeException {

    private String errorCode;
    private String errorMsg;



    public StudyException() {
    }

    public StudyException(String message) {
        super(message);
    }

    public StudyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudyException(Throwable cause) {
        super(cause);
    }

    public StudyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
