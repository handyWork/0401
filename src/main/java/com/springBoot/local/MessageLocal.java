package com.springBoot.local;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageLocal {

    public static final String DEF_MSG = "系统出现异常，请联系管理员";

    private static MessageSource messageSource;

    private static ApplicationContext applicationContext;

    static {
        messageSource = (MessageSource) applicationContext.getBean("messageSource");
        if (messageSource == null) {
            messageSource = new ResourceBundleMessageSource();
            ((ResourceBundleMessageSource) messageSource).setBasename("sys/locale/exception");
            ((ResourceBundleMessageSource) messageSource).setDefaultEncoding("UTF-8");
        }

    }

    public static String getMessageSource(String code) {
        return messageSource.getMessage(code, null, DEF_MSG, getLocal());
    }

    public static String getMessage(String code, String defMsg) {
        return messageSource.getMessage(code, null, defMsg, getLocal());
    }

    //解析用户当前的Local
    public static Locale getLocal() {
        return LocaleContextHolder.getLocale();
    }


}
