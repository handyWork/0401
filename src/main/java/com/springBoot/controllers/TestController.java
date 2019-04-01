package com.springBoot.controllers;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册服务提供者
 */
@Controller
//@RestController  // 整合了@Controller和@ResponseBody这两个注解 用这个注解controller则controller中的方法无法返回jsp页面   配置的视图解析器不会起作用
public class TestController {

    private final Logger logger = Logger.getLogger(getClass());

//    @Autowired
//    private DiscoveryClient client;

    @RequestMapping("/hello")
    @ResponseBody
    public String index() {
//        ServiceInstance instance  = client.getLocalServiceInstance();
//        logger.info("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
        return "hello handy 我是服务提供者!!";
    }
}
