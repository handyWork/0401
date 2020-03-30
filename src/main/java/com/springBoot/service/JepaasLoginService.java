package com.springBoot.service;

import com.springBoot.entity.JepaasEndUser;
import com.springBoot.result.BaseRespResult;

public interface JepaasLoginService {

    /**
     * 登录
     *
     * @param phone    手机号
     * @param password 密码
     * @param type     类型
     * @param codeDomo 验证码
     * @return
     */
    BaseRespResult<String> login(String phone, String password, String type, String codeDomo);

    /**
     * 注册
     *
     * @param phone    手机号
     * @param name     名称
     * @param email    email
     * @param password 密码
     * @param codeDomo 验证码
     * @return
     */
    BaseRespResult<String> signIn(String phone, String name, String email, String password, String codeDomo);

    /**
     * 发送验证码
     *
     * @param phone
     * @return
     */
    BaseRespResult<String> sendRandom(String phone);

    /**
     * 构建用户信息
     * TODO   修改DynaBean信息
     * @param user
     * @return
     */
//    JepaasEndUser buildCurrentUser(DynaBean user);
    JepaasEndUser buildCurrentUser(String user);

    /**
     * 获取用户信息
     *
     * @param pk
     * @return
     */
    JepaasEndUser getUserInfo(String pk);

    /**
     * 登出
     *
     * @param tokenId
     * @return
     */
    BaseRespResult<String> logOut(String tokenId);

    /**
     * 完善个人信息
     *
     * @param endUser
     * @return
     */
    BaseRespResult<String> editUserInfo(JepaasEndUser endUser);

    /**
     * 修改密码
     *
     * @param oldPassWord
     * @param newPassword
     * @return
     */
    BaseRespResult editPassword(String phone, String oldPassWord, String newPassword);

    /**
     * 修改手机号
     *
     * @param oldPhone 修改前的手机号
     * @param phone    手机号
     * @param codeDomo 验证码
     * @return
     */
    BaseRespResult editPhone(String oldPhone, String phone, String codeDomo);


    /**
     * 找回密码
     *
     * @param phone       手机号
     * @param codeDomo    验证码
     * @param setPassword 设置密码
     * @return
     */
    BaseRespResult findPassword(String phone, String codeDomo, String setPassword);

    /**
     * 校验验证码是否正确
     *
     * @param phone    手机号
     * @param codeDomo 验证码
     * @return
     */
    BaseRespResult checkCodeDemo(String phone, String codeDomo);

}
