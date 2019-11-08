package com.cmz.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/23
 * @description 基于zookeeper的分布式锁工具类
 */
public class ZookeeperLockUtil {

    private static final String root = "/curator/test/locks";

    public static void concurrentOperation(LockCallBall callBall, String zkconfig) {
        try {
            //创建zookeeper的客户端
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client = CuratorFrameworkFactory.newClient(zkconfig, retryPolicy);
            client.start();

            //创建分布式锁, 锁空间的根节点路径为/curator/lock
            InterProcessMutex mutex = new InterProcessMutex(client, root);
            mutex.acquire();

            callBall.handle(); // 接口回调

            //完成业务流程, 释放锁
            mutex.release();

            //关闭客户端
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void concurrentOperation(LockCallBall callBall, String zkconfig, String lockname) {
        try {
            //创建zookeeper的客户端
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client = CuratorFrameworkFactory.newClient(zkconfig, retryPolicy);
            client.start();

            //创建分布式锁, 锁空间的根节点路径为/curator/lock
            InterProcessMutex mutex = new InterProcessMutex(client, root + "/" + lockname);
            mutex.acquire();

            callBall.handle(); // 接口回调

            //完成业务流程, 释放锁
            mutex.release();

            //关闭客户端
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract static class LockCallBall {
        public abstract void handle();
    }

}
