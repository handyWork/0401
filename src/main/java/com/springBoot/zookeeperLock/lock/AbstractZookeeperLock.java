package com.springBoot.zookeeperLock.lock;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 *  zookeeper实现分布式锁 主要是通过  创建临时节点 和 监听机制来实现
 *  当前类 运用了设计模式  模板方法模式
 */
public abstract class AbstractZookeeperLock implements ZookeeperLock {
    // zk地址
    protected String zkAdress = "127.0.0.1:2181";
    // 默认锁名称
    protected  String lock = "/";
    // zk 连接
    protected ZkClient zkClient = new ZkClient(zkAdress);
    // 倒计数器  （发令枪闭锁）
    protected CountDownLatch countDownLatch;

    // 加锁
    @Override
    public final void lock() {
        //  尝试获取锁
        if (tryLock()) {
            // 拿到锁
            System.out.println("获取锁成功。。。。");
        } else {
            // 尝试获取锁未成功，等待获取锁、阻塞   如果此处已经不阻塞了  那么可以继续向下执行尝试获取锁    递归
            waitLock();
            lock();
        }
    }

    // 解锁
    @Override
    public final void unLock() {
        //  临时节点：临时存储  当客户端和 zookeeper断开连接时，zookeeper自动删除当前节点  也可手动删除
        //  关闭连接就解锁了
        if (zkClient != null) {
            zkClient.close();
            System.out.println("解锁成功。。。。");
        }

        // 区别： 持久化节点：  永久存储在zookeeper中 只能手动删除
    }

    //  尝试获取锁
    protected abstract Boolean tryLock();

    //  等待获取锁
    protected abstract void waitLock();

}
