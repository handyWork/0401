package com.springBoot.zookeeperLock.lock;

/**
 * 定义zookeeper 锁接口
 */
public interface ZookeeperLock {
    /**
     * 加锁
     */
    void lock();

    /**
     * 解锁
     */
    void unLock();
}
