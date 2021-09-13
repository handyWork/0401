package com.testPackage.threadTest.AliTest.logistics.Controller;

import com.springBoot.core.base.MethodArgument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author handy
 * @version 1.0
 * @date 2021/3/20 20:23
 */
@Controller
@RequestMapping(value = "/je/ali/logistics")
public class LogisticsController {

    @RequestMapping(value = "/loadInfo", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody

    public void loadInfo(MethodArgument param) {

    }
}
