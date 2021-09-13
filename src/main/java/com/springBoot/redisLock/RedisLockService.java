package com.springBoot.redisLock;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * redis 设置分布式锁
 * 可以参考  https://www.cnblogs.com/moxiaotao/p/10829799.html
 */
@Component
public class RedisLockService {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁
     * @param jedis  Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime  超时时间
     * @return
     */
    public boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String set = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(set)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        // 这是一段 lua 脚本
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }


}
