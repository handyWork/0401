package com.springBoot.controllers;

import com.testPackage.redisTest.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("redisTest")
public class RedisTestController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/addRedis")
    @ResponseBody
    public String addRedis() {
        double random = Math.random();
        String key = String.valueOf(random);
        redisUtils.set(key, key+"random");
        String value = redisUtils.get(key);
        return "hello handy 我向redis中添加了一个key为"+key+"；值为"+value+"";
    }

}
