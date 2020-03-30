package com.springBoot.util;

import com.springBoot.entity.JepaasEndUser;

/**
 * jepaas网站中 当前登录用户信息获取
 */
public class SecurityJepaasUserHolder {
    /**
     * 存放登录用户
     */
    private static ThreadLocal<JepaasEndUser> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocalToken = new ThreadLocal<>();

    public static void putToken(String tokenId) {
        threadLocalToken.set(tokenId);
    }

    public static String getToken() {
        return threadLocalToken.get();
    }

    public static void put(JepaasEndUser t) {
        threadLocal.set(t);
    }

    private static JepaasEndUser get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static void removeAll() {
        threadLocal.remove();
        threadLocalToken.remove();
    }

    public static JepaasEndUser getCurrentUser() {
        JepaasEndUser currentUser = threadLocal.get();
        if (currentUser == null) {
            JepaasEndUser user = new JepaasEndUser();
            user.setUserId("SYSTEM");
            user.setUserName("系统");
            return user;
        } else {
            return currentUser;
        }
    }

}
