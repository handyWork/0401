package com.springBoot.core.base;

import com.alibaba.fastjson.JSON;
import com.springBoot.result.BaseRespResult;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@ControllerAdvice
public class PlatformExceptionHandler {

    public static void writeErrorMsg(HttpServletResponse response, BaseRespResult result) {
        writeErrorMsg(response, JSON.toJSONString(result));
    }

    public static void writeErrorMsg(HttpServletResponse response, String result) {
        response.setContentType("text/json; charset=utf-8");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            out.write(result.getBytes());
            out.flush();
        } catch (IOException e) {
            IOUtils.closeQuietly(out);
        }
    }
}
