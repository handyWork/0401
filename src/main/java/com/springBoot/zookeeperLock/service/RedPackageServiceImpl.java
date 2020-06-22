package com.springBoot.zookeeperLock.service;

import com.springBoot.zookeeperLock.lock.ZookeeperDistributedLock;
import org.springframework.stereotype.Service;

@Service("redPackageService")
public class RedPackageServiceImpl implements RedPackageService {


    @Override
    public int addRedPackage() {

        //todo  首先查下当前用户是否已经领过红包

        // 添加红包
        ZookeeperDistributedLock zookeeperDistributedLock = new ZookeeperDistributedLock("/addRedPackage");
        try {
            zookeeperDistributedLock.lock();
            // todo 添加红包操作  一个mapper  进行添加红包
        } finally {
            zookeeperDistributedLock.unLock();
        }
        return 0;

    }
}
