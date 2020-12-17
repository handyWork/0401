package com.testPackage.dateHandle;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.testPackage.dateHandle.dateUtile.DateUtils;
import com.testPackage.utils.MathExtend;
import org.assertj.core.util.Sets;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

@Service("dateService")
public class DateServiceImpl implements DateService {

    // 自定义上午上班时间
    private final static String MORNINGHOURS = "8:30:00";
    // 自定义上午下班时间
    private final static String MORNINGCLOSETIME = "11:30:00";
    // 自定义下午上班时间
    private final static String AFTERNOONHOURS = "13:00:00";
    // 自定义下午下班时间
    private final static String AFTERNOONCLOSETIME = "18:00:00";


    /**
     * 基本思路为：
     * 1. 首先算出两个日期之间的有效的天数（不包括年假 周六日 并且 加上调班日的天数）
     * 2. 计算出开始日期 和 结束日期的  无效工时（日期中包含时、分、秒）
     * 3. 实际有效的工时 = 有效的天数*每天的实际工作时间-（开始时间和结束时间这两个节点中的无效工时）
     *
     * @param startTimeStr
     * @param endTimeStr
     * @param returnObj
     */
    @Override
    public void handleDateAndHour(String startTimeStr, String endTimeStr, JSONObject returnObj) {
        Date startTime = DateUtils.getDate(startTimeStr, DateUtils.DAFAULT_DATETIME_FORMAT);
        Date endTime = DateUtils.getDate(endTimeStr, DateUtils.DAFAULT_DATETIME_FORMAT);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DAFAULT_DATE_FORMAT);
        // 初始化无效工时
        int startInvalidMinute = 0;
        int endInvalidMinute = 0;
        // 上午上班时间（分钟）
        int morningMinute = timeToMinute(MORNINGHOURS, "HH:mm:ss");
        // 上午下班时间（分钟）
        int morningCloseMinute = timeToMinute(MORNINGCLOSETIME, "HH:mm:ss");
        // 下午上班时间（分钟）
        int afternoonMinute = timeToMinute(AFTERNOONHOURS, "HH:mm:ss");
        // 下午下班时间（分钟）
        int afternoonCloseMinute = timeToMinute(AFTERNOONCLOSETIME, "HH:mm:ss");
        // 每天的工作时间
        int hour = (morningCloseMinute - morningMinute) + (afternoonCloseMinute - afternoonMinute);

        // 存放节假日的集合
        HashSet<String> holidaysSet = Sets.newHashSet();
        // 存放调班日集合
        HashSet<String> changeShiftSet = Sets.newHashSet();
        int startYear = DateUtil.year(startTime);
        int endYear = DateUtil.year(endTime);
        // 处理假日集合  开始的年份 和结束的年份
        handleDateCollection(holidaysSet, changeShiftSet, String.valueOf(startYear));
        handleDateCollection(holidaysSet, changeShiftSet, String.valueOf(endYear));

        //一、 假如开始和结束为同一天  并且  都不为节假日   则直接进行计算有效工时
        if (DateUtils.getDate(startTimeStr, DateUtils.DAFAULT_DATE_FORMAT).compareTo(DateUtils.getDate(endTimeStr, DateUtils.DAFAULT_DATE_FORMAT)) == 0) {
            double validHour = 0d;
            double dateCount = 0d;
            Calendar cal = Calendar.getInstance();
            //判断是否为周六日
            int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
            // 如果当天不在年假中  并且不为周六日   或者   当天在调班日中   则为有效天
            boolean state = !holidaysSet.contains(simpleDateFormat.format(startTime)) && week != 0 && week != 6;
            if (state || changeShiftSet.contains(simpleDateFormat.format(startTime))) {
                // 计算出当前开始日期  无效的工时
                startInvalidMinute = handleInvalidMinute(startTime, true);
                // 计算出当前结束日期  无效的工时
                endInvalidMinute = handleInvalidMinute(endTime, false);
                int sumMinute = hour - startInvalidMinute - endInvalidMinute;
                // 有效工时 （换算为小时）
                validHour = MathExtend.divide(sumMinute, 60, 2);
                // 有效天数  （换算为天数）
                dateCount = MathExtend.divide(sumMinute, 60 * (hour / 60), 2);
            }
            returnObj.put("dateCount", dateCount);
            returnObj.put("validHour", validHour);
        }

        // 二、 开始和结束不为同一天的情况
        // 不在年假中的有效天数
        double dateCount = calLeaveDays(startTime, endTime, holidaysSet, changeShiftSet);
        // 计算无效工时
        // 1. 如果开始日期不在节假日日期中  或者  开始日期在  调班日  日期中 则进行计算工时

        if (!holidaysSet.contains(simpleDateFormat.format(startTime)) || changeShiftSet.contains(simpleDateFormat.format(startTime))) {
            // 计算出当前开始日期  无效的工时
            startInvalidMinute = handleInvalidMinute(startTime, true);
        }

        if (!holidaysSet.contains(simpleDateFormat.format(endTime)) || changeShiftSet.contains(simpleDateFormat.format(endTime))) {
            // 计算出当前结束日期  无效的工时
            endInvalidMinute = handleInvalidMinute(endTime, false);
        }
        // 计算   有效工时  =   有效天数*每天的工时 - 无效的工时
        // 所有的有效工时
        int sumMinute = (int) ((hour * dateCount) - startInvalidMinute - endInvalidMinute);
        // 有效工时
        double validHour = MathExtend.divide(sumMinute, 60, 2);
        // 最终的有效天数（按照有效工时/每天的实际工作的工时）
        dateCount = MathExtend.divide(sumMinute, 60 * (hour / 60), 2);

        returnObj.put("dateCount", dateCount);
        returnObj.put("validHour", validHour);

    }


    /**
     * 将时间转换为分钟
     *
     * @param time   字符串时间
     * @param format 自定义格式
     * @return
     */
    private int timeToMinute(String time, String format) {
        Date xsTime = DateUtils.getDate(time, format);
        int hour = DateUtil.hour(xsTime, true);
        int minute = DateUtil.minute(xsTime);
        int sumMinute = hour * 60 + minute;
        return sumMinute;
    }


    /**
     * 计算无效工时
     *
     * @param data 时间数据
     * @param flag 标识  true 为开始时间，false 为结束时间
     * @return
     */
    public int handleInvalidMinute(Date data, boolean flag) {
        // 初始化一个时间
        int initMinute = 0;
        // 上午上班时间（分钟）
        int morningMinute = timeToMinute(MORNINGHOURS, "HH:mm:ss");
        // 上午下班时间（分钟）
        int morningCloseMinute = timeToMinute(MORNINGCLOSETIME, "HH:mm:ss");
        // 下午上班时间（分钟）
        int afternoonMinute = timeToMinute(AFTERNOONHOURS, "HH:mm:ss");
        // 下午下班时间（分钟）
        int afternoonCloseMinute = timeToMinute(AFTERNOONCLOSETIME, "HH:mm:ss");

        int hour = DateUtil.hour(data, true);
        int minute = DateUtil.minute(data);
        // 传递进来的是时间
        int dataMinute = hour * 60 + minute;
        // 一、 如果是开始时间  出现五种情况  计算无效工时
        if (flag) {
            // 1. 开始时间 小于 上班时间   不计入无效工时
            if (dataMinute < morningMinute) {
                return initMinute;
            }
            // 2. 大于上午上班时间  小于 上午下班时间   计算无效工时
            if (dataMinute >= morningMinute && dataMinute <= morningCloseMinute) {
                return dataMinute - morningMinute;
            }
            // 3. 大于 上午下班时间 并且 小于  下午上班时间   计算无效时间
            if (dataMinute > morningCloseMinute && dataMinute < afternoonMinute) {
                return morningCloseMinute - morningMinute;
            }
            // 4. 大于等于  下午上班时间   小于 下午下班时间
            if (dataMinute >= afternoonMinute && dataMinute <= afternoonCloseMinute) {
                return (dataMinute - afternoonMinute) + (morningCloseMinute - morningMinute);
            }
            // 5. 大于下班时间
            if (dataMinute > afternoonCloseMinute) {
                return (morningCloseMinute - morningMinute) + (afternoonCloseMinute - afternoonMinute);
            }
        }


        //二 、  如果是结束时间   计算无效工时
        // 1. 结束时间 小于  上班时间   计算无效工时
        if (dataMinute < morningMinute) {
            return (morningCloseMinute - morningMinute) + (afternoonCloseMinute - afternoonMinute);
        }
        // 2. 大于上午上班时间  小于 上午下班时间   计算无效工时
        if (dataMinute >= morningMinute && dataMinute <= morningCloseMinute) {
            return (afternoonCloseMinute - afternoonMinute) + (morningCloseMinute - dataMinute);
        }
        // 3. 大于 上午下班时间 并且 小于  下午上班时间   计算无效时间
        if (dataMinute > morningCloseMinute && dataMinute < afternoonMinute) {
            return afternoonCloseMinute - afternoonMinute;
        }
        // 4. 大于等于  下午上班时间   小于 下午下班时间
        if (dataMinute >= afternoonMinute && dataMinute <= afternoonCloseMinute) {
            return afternoonCloseMinute - dataMinute;
        }
        // 5. 大于下班时间
        if (dataMinute > afternoonCloseMinute) {
            return initMinute;
        }
        return initMinute;
    }

    /**
     * 处理假日集合
     *
     * @param holidaysSet    节假日的集合
     * @param changeShiftSet 调班日集合
     * @param startYear      传入的年份
     */
    private void handleDateCollection(HashSet<String> holidaysSet, HashSet<String> changeShiftSet, String startYear) {

        /*  TODO  根据自己的业务自行实现
         * 处理节假日  和  调班日 集合
         * 自己在数据库中获取到  自定义维护的 节假日和 调班日数据
         * 将所有自定义的节假日和 调班日装到 set集合中
         * */
    }

    /**
     * 计算 起始日期到结束日期   去除周六日 和  年假  其中包含多少天
     * （传递进来的开始时间和 结束时间不能为同一天  如果为同一天的话，需要单独处理）
     *
     * @param startTime      开始时间
     * @param endTime        结束时间
     * @param holidaysSet    节假日集合
     * @param changeShiftSet 调班日集合
     * @return
     */
    public double calLeaveDays(Date startTime, Date endTime, HashSet<String> holidaysSet, HashSet<String> changeShiftSet) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DAFAULT_DATE_FORMAT);

        double leaveDays = 0;
//从startTime开始循环，若该日期不是节假日或者不是周六日则请假天数+1
        Date flag = startTime;//设置循环开始日期
        Calendar cal = Calendar.getInstance();
//循环遍历每个日期
        while (flag.compareTo(endTime) != 1) {
            cal.setTime(flag);
//判断是否为周六日
            int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (week == 0 || week == 6) {//0为周日，6为周六
                //跳出循环进入下一个日期
                cal.add(Calendar.DAY_OF_MONTH, +1);
                flag = cal.getTime();
                continue;
            }
            //判断是否为节假日
            try {
                // 在节假日集合中 判断是否存在于当前集合中
                if (holidaysSet.contains(simpleDateFormat.format(flag))) {
                    //跳出循环进入下一个日期
                    cal.add(Calendar.DAY_OF_MONTH, +1);
                    flag = cal.getTime();
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//不是节假日或者周末，天数+1
            leaveDays = leaveDays + 1;
//日期往后加一天
            cal.add(Calendar.DAY_OF_MONTH, +1);
            flag = cal.getTime();
        }


        // TODO  处理是否有 调班日的日期
        Date flag2 = startTime;
        Calendar cal2 = Calendar.getInstance();
        while (flag2.compareTo(endTime) != 1) {
            cal2.setTime(flag2);
            // 判断是否为调休日  如果为调休日的话 则再加一天
            if (changeShiftSet.contains(simpleDateFormat.format(flag2))) {
                leaveDays = leaveDays + 1;
            }
            cal2.add(Calendar.DAY_OF_MONTH, +1);
            flag2 = cal2.getTime();
        }

        return leaveDays;
    }
}
