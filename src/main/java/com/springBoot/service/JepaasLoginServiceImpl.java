package com.springBoot.service;

import com.springBoot.entity.JepaasEndUser;
import com.springBoot.result.BaseRespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Service;

@Service("jepaasLoginService")
public class JepaasLoginServiceImpl implements JepaasLoginService {
    //    @Autowired
//    private PCDynaServiceTemplate serviceTemplate;
//    @Autowired
//    private RedisCache redisCache;

    /**
     * 定义redis中缓存的key
     */
    private static String userLoginCacheKey = "jepaasLoginUser";

//    @Override
//    public BaseRespResult<String> login(String phone, String password, String type, String codeDomo) {
//
//        // 首先判断登录的类型
//        // 普通登录
//        if (type.equals("general")) {
//            // 1. 账号密码登录
//            // 1.1 先校验手机号是否注册
//            DynaBean userBean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + phone + "");
//            if (userBean == null) {
//                throw new PlatformException("该手机号没有注册", PlatformExceptionEnum.UNKOWN_ERROR);
//            }
//
//            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//            password = md5.encodePassword(password, null);
//            if (!password.equals(userBean.getStr("ENDUSER_PASSWORD"))) {
//                throw new PlatformException("密码错误", PlatformExceptionEnum.UNKOWN_ERROR);
//            }
//            //登陆成功, 在redis中放入信息
//            String tokenId = JEUUID.uuid();
//            JepaasEndUser endUser = buildCurrentUser(userBean);
//            redisCache.hashPut(userLoginCacheKey, tokenId, endUser);
//
//            return BaseRespResult.successResult(tokenId, "登录成功");
//        }
//        // 动态登录
//        if (type.equals("dynamic")) {
//            // 2. 动态密码登录
//            DynaBean userBean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + phone + "");
//            if (userBean == null) {
//                throw new PlatformException("未查询到该手机号", PlatformExceptionEnum.UNKOWN_ERROR);
//            }
//            // 校验验证码是否通过
//            checkCodeDemo(userBean.getStr("ENDUSER_SXSJ"), userBean.getStr("ENDUSER_YZM"), codeDomo);
//            //登陆成功, 在redis中放入信息
//            String tokenId = JEUUID.uuid();
//            JepaasEndUser endUser = buildCurrentUser(userBean);
//            TokenJepaasUserCacheManager.putCacheValue(tokenId, endUser);
//            return BaseRespResult.successResult(tokenId, "登录成功");
//        }
//        return BaseRespResult.successResult("登录成功");
//    }
//
//    @Override
//    public JepaasEndUser buildCurrentUser(DynaBean user) {
//        JepaasEndUser endUser = new JepaasEndUser();
//        endUser.setEmail(user.getStr("ENDUSER_YX"));
//        endUser.setGsmc(user.getStr("ENDUSER_GSMC"));
//        endUser.setPhone(user.getStr("ENDUSER_SJH"));
//        endUser.setPhoto(user.getStr("ENDUSER_TX"));
//        endUser.setQyxzCode(user.getStr("ENDUSER_QYXZ_CODE"));
//        endUser.setQyxzName(user.getStr("ENDUSER_QYXZ_NAME"));
//        endUser.setSshyCode(user.getStr("ENDUSER_SSHY_CODE"));
//        endUser.setSshyName(user.getStr("ENDUSER_SSHY_NAME"));
//        endUser.setUserId(user.getStr("JEPAAS_ENDUSER_ID"));
//        endUser.setShengName(user.getStr("ENDUSER_SHENG_NAME"));
//        endUser.setShengCode(user.getStr("ENDUSER_SHENG_CODE"));
//        endUser.setShiName(user.getStr("ENDUSER_SHI_NAME"));
//        endUser.setShiCode(user.getStr("ENDUSER_SHI_CODE"));
//        endUser.setUserName(user.getStr("ENDUSER_XM"));
//        endUser.setUserId(user.getStr("JEPAAS_ENDUSER_ID"));
//        return endUser;
//    }
//
//    @Override
//    public BaseRespResult<String> signIn(String phone, String name, String email, String password, String codeDomo) {
//        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//        password = md5.encodePassword(password, null);
//        // 获取验证码的bean
//        DynaBean userBean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + phone + "");
//
//        // 判断该手机是否注册
//        if (userBean == null) {
//            throw new PlatformException("验证码发送失败。", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//        if (StringUtil.isNotEmpty(userBean.getStr("ENDUSER_PASSWORD"))) {
//            throw new PlatformException("该手机已经注册过。", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//
//        // 校验验证码是否通过
//        checkCodeDemo(userBean.getStr("ENDUSER_SXSJ"), userBean.getStr("ENDUSER_YZM"), codeDomo);
//
//        // 进行注册
//        userBean.setStr("ENDUSER_XM", name);
//        userBean.setStr("ENDUSER_YX", email);
//        userBean.setStr("ENDUSER_PASSWORD", password);
//        serviceTemplate.buildModelModifyInfo(userBean);
//        serviceTemplate.update(userBean);
//
//        return BaseRespResult.successResult("注册成功");
//    }
//
//    /**
//     * 校验验证码是否过期
//     *
//     * @param date
//     */
//    /**
//     * 校验验证码是否通过
//     *
//     * @param date    过期时间
//     * @param oldCode 库中存储的验证码
//     * @param newCode 需要校验的验证码
//     */
//    private void checkCodeDemo(String date, String oldCode, String newCode) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        //将字符串形式的时间转化为Date类型的时间
//        try {
//            Date failureTime = sdf.parse(date);
//            Date newDate = new Date();
//            if (newDate.after(failureTime)) {
//                throw new PlatformException("验证码已经过期，请重新发送。", PlatformExceptionEnum.UNKOWN_ERROR);
//            }
//            if (!oldCode.equalsIgnoreCase(newCode)) {
//                throw new PlatformException("验证码不一致，请重新填写。", PlatformExceptionEnum.UNKOWN_ERROR);
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public BaseRespResult<String> sendRandom(String phone) {
//
//        String code = RandomUtil.randomNumbers(6);
//        String context = "您好，您的验证码是:" + code;
//        Map<String, Object> sysVars = WebUtils.getAllSysVar(SecurityUserHolder.getCurrentUser().getZhId());
//        Note253Util note253Util = Note253Util.getInstance(sysVars.get("NOTE_253_USERNAME") + "", sysVars.get("NOTE_253_PASSWORD") + "", sysVars.get("NOTE_253_SIGN") + "", sysVars.get("NOTE_253_REPORT") + "", sysVars.get("NOTE_253_SENDURL") + "");
//
//        DynaBean zcUser = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + phone + "");
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date now = new Date();
//        if (zcUser == null) {
//            // 将验证码添加到用户表中
//            DynaBean userBean = new DynaBean("JEPAAS_ENDUSER", false);
//            userBean.setStr(BeanUtils.KEY_PK_CODE, "JEPAAS_ENDUSER_ID");
//
//            Date afterDate = new Date(now.getTime() + 300000);
//            userBean.setStr("ENDUSER_SJH", phone);
//            userBean.setStr("ENDUSER_SXSJ", sdf.format(afterDate));
//            userBean.setStr("ENDUSER_YZM", code);
//            serviceTemplate.buildModelCreateInfo(userBean);
//            serviceTemplate.insert(userBean);
//        } else {
//            Date afterDate = new Date(now.getTime() + 300000);
//            zcUser.setStr("ENDUSER_SJH", phone);
//            zcUser.setStr("ENDUSER_SXSJ", sdf.format(afterDate));
//            zcUser.setStr("ENDUSER_YZM", code);
//            serviceTemplate.buildModelModifyInfo(zcUser);
//            serviceTemplate.update(zcUser);
//        }
//
//
//        // 插入短信发送记录表中
//        DynaBean bean = new DynaBean("JE_SYS_NOTELOG", false);
//        bean.setStr(BeanUtils.KEY_PK_CODE, "JE_SYS_NOTELOG_ID");
//        bean.setStr("NOTELOG_PHONENUMBER", phone);
//        bean.setStr("NOTELOG_SENDTIME", sdf.format(now));
//        bean.setStr("NOTELOG_FROMUSERID", SecurityUserHolder.getCurrentUser().getUserId());
//        bean.setStr("NOTELOG_TOUSER", phone);
//        bean.setStr("NOTELOG_CONTEXT", context);
//        bean.setStr("NOTELOG_FROMUSER", SecurityUserHolder.getCurrentUser().getUsername());
//        bean.setStr("NOTELOG_SENDCOUNT", "1");
//        try {
//            note253Util.sendNote(phone, context);
//            bean.setStr("NOTELOG_STATUS", "成功");
//            serviceTemplate.buildModelCreateInfo(bean);
//            serviceTemplate.insert(bean);
//        } catch (Exception e) {
//            e.printStackTrace();
//            bean.setStr("NOTELOG_STATUS", "失败");
//            serviceTemplate.buildModelCreateInfo(bean);
//            serviceTemplate.insert(bean);
//        }
//        return BaseRespResult.successResult("验证码已发送，请查收!");
//    }
//
//    @Override
//    public JepaasEndUser getUserInfo(String pk) {
//        String userId = pk;
//        if (StringUtil.isEmpty(pk)) {
//            userId = SecurityJepaasUserHolder.getCurrentUser().getUserId();
//        }
//        DynaBean bean = serviceTemplate.selectOneByPk("JEPAAS_ENDUSER", userId);
//        if (bean == null) {
//            throw new PlatformException("没有查询到当前用户信息", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//        return buildCurrentUser(bean);
//    }
//
//    @Override
//    public BaseRespResult<String> logOut(String tokenId) {
//        if (StringUtils.isNotEmpty(tokenId)) {
//            TokenJepaasUserCacheManager.removeCacheValue(tokenId);
//            redisCache.hashDelete(userLoginCacheKey, tokenId);
//        }
//        return BaseRespResult.successResult("登出成功!");
//    }
//
//    @Override
//    public BaseRespResult<String> editUserInfo(JepaasEndUser endUser) {
//        DynaBean bean = serviceTemplate.selectOneByPk("JEPAAS_ENDUSER", endUser.getUserId());
//        bean.set("ENDUSER_YX", endUser.getEmail());
//        bean.set("ENDUSER_GSMC", endUser.getGsmc());
//        bean.set("ENDUSER_XM", endUser.getUserName());
//
//        bean.set("ENDUSER_QYXZ_CODE", endUser.getQyxzCode());
//        bean.set("ENDUSER_QYXZ_NAME", endUser.getQyxzName());
//        bean.set("ENDUSER_SSHY_CODE", endUser.getSshyCode());
//        bean.set("ENDUSER_SSHY_NAME", endUser.getSshyName());
//
//        bean.set("ENDUSER_SHENG_CODE", endUser.getShengCode());
//        bean.set("ENDUSER_SHENG_NAME", endUser.getShengName());
//        bean.set("ENDUSER_SHI_CODE", endUser.getShiCode());
//        bean.set("ENDUSER_SHI_NAME", endUser.getShiName());
//
//        serviceTemplate.buildModelModifyInfo(bean);
//        serviceTemplate.update(bean);
//        return BaseRespResult.successResult("修改成功!");
//    }
//
//    @Override
//    public BaseRespResult editPassword(String phone, String oldPassWord, String newPassword) {
//
//        DynaBean bean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + phone + "");
//        if (bean == null) {
//            throw new PlatformException("没有查询该注册账号", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//        oldPassWord = md5.encodePassword(oldPassWord, null);
//        if (!oldPassWord.equals(bean.getStr("ENDUSER_PASSWORD"))) {
//            throw new PlatformException("与原密码不符合，不允许修改", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//
//        newPassword = md5.encodePassword(newPassword, null);
//        bean.setStr("ENDUSER_PASSWORD", newPassword);
//        serviceTemplate.buildModelModifyInfo(bean);
//        serviceTemplate.update(bean);
//        return BaseRespResult.successResult("修改密码成功!");
//    }
//
//    @Override
//    public BaseRespResult editPhone(String oldPhone, String newPhone, String codeDomo) {
//        // 获取验证码的bean
//        DynaBean userBean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + oldPhone + "");
//        if (userBean == null) {
//            throw new PlatformException("没有找到当前手机号。", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//
//        DynaBean newPhoneBean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + newPhone + "");
//        if (newPhoneBean != null) {
//            throw new PlatformException("要修改的手机号已经存在。", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//
//        // 校验验证码是否通过
//        checkCodeDemo(userBean.getStr("ENDUSER_SXSJ"), userBean.getStr("ENDUSER_YZM"), codeDomo);
//
//        userBean.setStr("ENDUSER_SJH", newPhone);
//
//        serviceTemplate.buildModelModifyInfo(userBean);
//        serviceTemplate.update(userBean);
//        return BaseRespResult.successResult("修改手机号成功!");
//    }
//
//    @Override
//    public BaseRespResult findPassword(String phone, String codeDomo, String setPassword) {
//        DynaBean userBean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + phone + "");
//        if (userBean == null) {
//            throw new PlatformException("未查询到该手机号", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//        // 校验验证码是否通过
//        checkCodeDemo(userBean.getStr("ENDUSER_SXSJ"), userBean.getStr("ENDUSER_YZM"), codeDomo);
//
//        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//        setPassword = md5.encodePassword(setPassword, null);
//
//        userBean.setStr("ENDUSER_PASSWORD", setPassword);
//        serviceTemplate.buildModelModifyInfo(userBean);
//        serviceTemplate.update(userBean);
//        return BaseRespResult.successResult("修改密码成功!");
//    }
//
//    @Override
//    public BaseRespResult checkCodeDemo(String phone, String codeDomo) {
//        DynaBean userBean = serviceTemplate.selectOne("JEPAAS_ENDUSER", " AND ENDUSER_SJH = " + phone + "");
//        if (userBean == null) {
//            throw new PlatformException("找回密码时，未查询到该手机号", PlatformExceptionEnum.UNKOWN_ERROR);
//        }
//        // 校验验证码是否通过
//        checkCodeDemo(userBean.getStr("ENDUSER_SXSJ"), userBean.getStr("ENDUSER_YZM"), codeDomo);
//        return BaseRespResult.successResult("校验成功!");
//    }


    @Override
    public BaseRespResult<String> login(String phone, String password, String type, String codeDomo) {
        return null;
    }

    @Override
    public BaseRespResult<String> signIn(String phone, String name, String email, String password, String codeDomo) {
        return null;
    }

    @Override
    public BaseRespResult<String> sendRandom(String phone) {
        return null;
    }

    @Override
    public JepaasEndUser buildCurrentUser(String user) {
        return null;
    }

    @Override
    public JepaasEndUser getUserInfo(String pk) {
        return null;
    }

    @Override
    public BaseRespResult<String> logOut(String tokenId) {
        return null;
    }

    @Override
    public BaseRespResult<String> editUserInfo(JepaasEndUser endUser) {
        return null;
    }

    @Override
    public BaseRespResult editPassword(String phone, String oldPassWord, String newPassword) {
        return null;
    }

    @Override
    public BaseRespResult editPhone(String oldPhone, String phone, String codeDomo) {
        return null;
    }

    @Override
    public BaseRespResult findPassword(String phone, String codeDomo, String setPassword) {
        return null;
    }

    @Override
    public BaseRespResult checkCodeDemo(String phone, String codeDomo) {
        return null;
    }
}
