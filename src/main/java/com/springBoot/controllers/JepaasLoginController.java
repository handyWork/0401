package com.springBoot.controllers;

import com.springBoot.core.base.MethodArgument;
import com.springBoot.entity.JepaasEndUser;
import com.springBoot.exception.ExceptionEnum;
import com.springBoot.exception.PlatformException;
import com.springBoot.result.BaseRespResult;
import com.springBoot.service.JepaasLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/jepaas/login")
public class JepaasLoginController {

    @Autowired
    private JepaasLoginService loginService;

    @ResponseBody
    @RequestMapping(value = {"/signIn"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult<String> signIn(MethodArgument param) {
        HttpServletRequest request = param.getRequest();
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // 验证码
        String codeDomo = request.getParameter("codeDomo");
        return loginService.signIn(phone, name, email, password, codeDomo);
    }

    @ResponseBody
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult<String> login(MethodArgument param) {
        HttpServletRequest request = param.getRequest();

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        // 验证码
        String codeDomo = request.getParameter("codeDomo");

        if (StringUtils.isEmpty(type)) {
            throw new PlatformException("type 不能为空", ExceptionEnum.UNKOWN_ERROR);
        }
        return loginService.login(phone, password, type, codeDomo);
    }

    @ResponseBody
    @RequestMapping(value = {"/sendRandom"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult<String> sendRandom(MethodArgument param) {
        HttpServletRequest request = param.getRequest();
        String phone = request.getParameter("phone");

        String format = "^1[3456789]\\d{9}$";
        if (!phone.matches(format)) {
            throw new PlatformException("手机号格式不正确！", ExceptionEnum.UNKOWN_ERROR);
        }

        return loginService.sendRandom(phone);
    }

    @ResponseBody
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult<String> logout(MethodArgument param) {
        String tokenId = param.getRequest().getParameter("tokenId");
        return loginService.logOut(tokenId);
    }

    @ResponseBody
    @RequestMapping(value = {"/editUserInfo"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult editUserInfo(MethodArgument param) {
        HttpServletRequest request = param.getRequest();
        JepaasEndUser endUser = new JepaasEndUser();
        endUser.setUserId(request.getParameter("userId"));
        endUser.setUserName(request.getParameter("name"));
        endUser.setEmail(request.getParameter("email"));
        endUser.setShengCode(request.getParameter("shengCode"));
        endUser.setShengName(request.getParameter("shengName"));
        endUser.setShiCode(request.getParameter("shiCode"));
        endUser.setShiName(request.getParameter("shiName"));

        endUser.setQyxzName(request.getParameter("qyxzName"));
        endUser.setQyxzCode(request.getParameter("qyxzCode"));
        endUser.setGsmc(request.getParameter("gsmc"));
        endUser.setSshyName(request.getParameter("sshyName"));
        endUser.setSshyCode(request.getParameter("sshyCode"));

        return loginService.editUserInfo(endUser);
    }

    @ResponseBody
    @RequestMapping(value = {"/editPassword"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult editPassword(MethodArgument param) {
        HttpServletRequest request = param.getRequest();
        String phone = request.getParameter("phone");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        String format = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{2,16}$";
        if (!newPassword.matches(format)) {
            throw new PlatformException("密码必须为2到16位字母+数字组成。", ExceptionEnum.UNKOWN_ERROR);
        }
        return loginService.editPassword(phone, oldPassword, newPassword);
    }

    @ResponseBody
    @RequestMapping(value = {"/editPhone"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult editPhone(MethodArgument param) {
        HttpServletRequest request = param.getRequest();
        String oldPhone = request.getParameter("oldPhone");
        String codeDomo = request.getParameter("codeDomo");
        String newPhone = request.getParameter("newPhone");

        String format = "^1[3456789]\\d{9}$";
        if (!newPhone.matches(format)) {
            throw new PlatformException("手机号格式不正确！", ExceptionEnum.UNKOWN_ERROR);
        }
        return loginService.editPhone(oldPhone, newPhone, codeDomo);
    }

    @ResponseBody
    @RequestMapping(value = {"/getUserInfoById"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult getUserInfoById(MethodArgument param) {
        HttpServletRequest request = param.getRequest();
        String userId = request.getParameter("userId");
        JepaasEndUser userInfo = loginService.getUserInfo(userId);
        return BaseRespResult.successResult(userInfo, "获取用户信息成功！");
    }

    @ResponseBody
    @RequestMapping(value = {"/findPassword"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public BaseRespResult findPassword(MethodArgument param) {
        HttpServletRequest request = param.getRequest();
        String phone = request.getParameter("phone");
        String codeDomo = request.getParameter("codeDomo");

        String setPassword = request.getParameter("setPassword");
        String confirPassword = request.getParameter("confirPassword");


        String format = "^1[3456789]\\d{9}$";
        if (!phone.matches(format)) {
            throw new PlatformException("手机号格式不正确！", ExceptionEnum.UNKOWN_ERROR);
        }

        if (StringUtils.isEmpty(setPassword)) {
            return loginService.checkCodeDemo(phone, codeDomo);
        }

        if (!setPassword.equals(confirPassword)) {
            throw new PlatformException("两次密码输入不一致，不允许修改", ExceptionEnum.UNKOWN_ERROR);
        }
        return loginService.findPassword(phone, codeDomo, setPassword);
    }

}
