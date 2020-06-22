package com.springBoot.zookeeperLock.lock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * zookeeperLock  分布式锁
 */
public class ZookeeperDistributedLock extends AbstractZookeeperLock {

    public ZookeeperDistributedLock(String lockName) {
        lock = lockName;
    }

    // 尝试获取锁
    @Override
    protected Boolean tryLock() {
        // 通过创建一个临时节点来尝试获取锁
        try {
            zkClient.createEphemeral(lock);
            return true;
        } finally {
            return  false;
        }
    }

    // 等待获取锁
    @Override
    protected void waitLock() {

        // 如果已经有线程创建了临时节点  那么其他线程只能进入等待状态  不能创建临时节点
        IZkDataListener listener = new IZkDataListener() {
            // 监听数据改变
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }
            // 监听数据删除
            @Override
            public void handleDataDeleted(String s) throws Exception {
                //
                if(countDownLatch != null){
                    // 倒计时减1
                    countDownLatch.countDown();
                }

            }
        };
        //1. 创建一个监听  订阅数据改变  用于监听数据节点的改变
        zkClient.subscribeDataChanges(lock,listener);

        //2. 判断锁的节点是否存在
        if(zkClient.exists(lock)){
            // 创建一个倒计数器
             countDownLatch = new CountDownLatch(1);
            try {
                this.countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 3.  将订阅给取消掉
        zkClient.unsubscribeDataChanges(lock,listener);

    }


}


















