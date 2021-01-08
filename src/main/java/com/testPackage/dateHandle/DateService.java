package com.testPackage.dateHandle;

import com.alibaba.fastjson.JSONObject;

/**
 * 处理  HR模块的  天数和工时
 */
public interface DateService {
    /**
     * 获取 时间  天数 (精确计算)
     * @param startTimeStr 开始申请时间
     * @param endTimeStr   结束时间
     * @param returnObj    返回给前端的对象
     */
    void handleDateAndHour(String startTimeStr, String endTimeStr, JSONObject returnObj);
}
