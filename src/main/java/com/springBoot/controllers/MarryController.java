package com.springBoot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("marry")
public class MarryController {


    @RequestMapping("/happy")
    @ResponseBody
    public String marry() throws ParseException {
        //设定纪念日期
        String dstr = "2020-04-12 08:08:08 ";
        //获取当前日期
//        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = sdf.parse(dstr);
        long s1 = date.getTime();//将时间转为毫秒
        long s2 = System.currentTimeMillis();//得到当前的毫秒
        int day = (int) ((s1 - s2) / 1000 / 60 / 60 / 24);
        return "距离杨智、戚静雨结婚日期还有" + day + "天，加油！";
    }
}
