package com.cmz.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/23
 * @description 分布式锁：基于redis实现
 */
public class DistributedLock {

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
