package com.springBoot.filter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.springBoot.core.base.PlatformExceptionHandler;
import com.springBoot.entity.JepaasEndUser;
import com.springBoot.exception.ExceptionEnum;
import com.springBoot.result.BaseRespResult;
import com.springBoot.util.SecurityJepaasUserHolder;
import com.springBoot.util.TokenJepaasUserCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JepaasSessionFilter extends OncePerRequestFilter {

    public static final String X_AUTH_TOKEN = "jepaasAuthorization";
    public static final Logger logger = LoggerFactory.getLogger(JepaasSessionFilter.class);
    //需要放开的接口
    public static final String[] noFilters = new String[]{"/jepaas/login/**",
            "/jepaas/product/loadProductInfo",
            "/jepaas/product/loadTacticsByProductId"};

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean doFilter = true;
        SecurityJepaasUserHolder.removeAll();

        try {
            String uri = request.getRequestURI();
            for (String s : noFilters) {
                if (s.indexOf("**") != -1) {
                    s = s.substring(0, s.indexOf("**"));
                    if (uri.indexOf(s) != -1) {
                        doFilter = false;
                        break;
                    }
                } else if (s.equals(uri)) {
                    doFilter = false;
                    break;
                }
            }

            JepaasEndUser user = null;
            try {
                boolean cookieUser = false;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        String name = cookie.getName();
                        if (X_AUTH_TOKEN.equals(name)) {
                            String tokenId = cookie.getValue();
                            user = TokenJepaasUserCacheManager.getCacheValue(tokenId);
                            if (null != user) {
                                SecurityJepaasUserHolder.put(user);
                                SecurityJepaasUserHolder.putToken(tokenId);
                                cookieUser = true;
                            }
                        }
                    }
                }
                if (!cookieUser && StrUtil.isNotEmpty(request.getParameter(X_AUTH_TOKEN))) {
                    String tokenId = request.getParameter(X_AUTH_TOKEN);
                    user = TokenJepaasUserCacheManager.getCacheValue(tokenId);
                    if (null != user) {
                        SecurityJepaasUserHolder.put(user);
                        SecurityJepaasUserHolder.putToken(tokenId);
                    }
                }
            } catch (Exception e) {
//                PlatformException pEx = new PlatformException("用户没有登陆或者已经超时.", ExceptionEnum.JE_RBAC_FILTER_ERROR, request, e);
//                PlatformExceptionHandler.hanndleError(pEx, request, response);
                PlatformExceptionHandler.writeErrorMsg(response, BaseRespResult.errorResult(ExceptionEnum.JE_RBAC_FILTER_ERROR + ""
                        , "用户没有登陆或者已经超时"));
                return;
            }

            if (doFilter) {
                if (null != user) {
                    filterChain.doFilter(request, response);
                } else {
                    logger.info("进入JepaasSessionFilter过滤器[Session是空的请求!] [{}]   参数: [{}]", uri
                            , JSON.toJSONString(request.getParameterMap()));
                    PlatformExceptionHandler.writeErrorMsg(response, BaseRespResult.errorResult(ExceptionEnum.UNKOWN_LOGINUSER + ""
                            , "用户未登录"));
                }
                return;
            }
        } catch (Exception e) {
//            PlatformException pEx = new PlatformException("当前用户解析过滤器异常", ExceptionEnum.JE_RBAC_FILTER_ERROR, request, e);
//            PlatformExceptionHandler.hanndleError(pEx, request, response);
            PlatformExceptionHandler.writeErrorMsg(response, BaseRespResult.errorResult(ExceptionEnum.JE_RBAC_FILTER_ERROR + ""
                    , "当前用户解析过滤器异常"));
        }

        //继续执行
        filterChain.doFilter(request, response);
    }
}
