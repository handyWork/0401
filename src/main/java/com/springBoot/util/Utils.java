package com.springBoot.util;

import cn.hutool.core.util.StrUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    /**
     * 设置时间
     *
     * @param vipTime  购买的vip期限
     * @param deadline 截止时间
     * @return
     */
    public static String setVipTime(String vipTime, String deadline) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Calendar deadlineDate = Calendar.getInstance();
        Date parse = null;
        try {
            deadline = StrUtil.isEmpty(deadline) ? dateFormat.format(new Date()) : deadline;
            parse = dateFormat.parse(deadline);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        deadlineDate.setTime(parse);
        // 当前时间是否在购买的时间之前  如果为true  则没有过期
        boolean OverdueStatus = calendar.before(deadlineDate);
        // 如果没有过期  则追加时间
        if (OverdueStatus == true) {
            calendar.setTime(parse);
        }
        calendar.add(Calendar.MONTH, +Integer.valueOf(vipTime));
        return dateFormat.format(calendar.getTime());
    }
}
