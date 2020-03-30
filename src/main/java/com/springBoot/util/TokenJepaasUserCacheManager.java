package com.springBoot.util;

import com.springBoot.core.redis.RedisCache;
import com.springBoot.core.util.SpringContextHolder;
import com.springBoot.entity.JepaasEndUser;

/**
 * jepaas用户缓存
 */
public class TokenJepaasUserCacheManager {

    private static RedisCache redisCache;

    private static String userLoginCacheKey = "jepaasLoginUser";

    /**
     * 获取缓存信息
     *
     * @param key
     * @return
     */
    public static JepaasEndUser getCacheValue(String key) {
        if (redisCache == null) {
            redisCache = SpringContextHolder.getBean("redisCache");
        }
        return (JepaasEndUser) redisCache.hashGet(userLoginCacheKey, key);
    }

    /**
     * 添加缓存信息
     *
     * @param key
     * @param obj
     */
    public static void putCacheValue(String key, JepaasEndUser obj) {
        if (redisCache == null) {
            redisCache = SpringContextHolder.getBean("redisCache");
        }
        redisCache.hashPut(userLoginCacheKey, key, obj);
    }

    /**
     * 删除指定缓存
     *
     * @param key
     */
    public static void removeCacheValue(String key) {
        if (redisCache == null) {
            redisCache = SpringContextHolder.getBean("redisCache");
        }
        redisCache.hashDelete(userLoginCacheKey, key);
    }


}
