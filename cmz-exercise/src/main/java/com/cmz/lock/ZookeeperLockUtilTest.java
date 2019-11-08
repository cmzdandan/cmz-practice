package com.cmz.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/23
 * @description 基于zookeeper的分布式锁工具类的测试
 * <p>
 *  参考：https://github.com/huangyueranbbc/DistributedLock
 * </p>
 */
public class ZookeeperLockUtilTest {

    private static Map<Integer, Integer> cacheMap = new HashMap<>();
    private static int index = 0;

    public static void main(String[] args) {
        final String zkConfig = "10.0.30.91:2181";
        final String lockname="incr";
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    ZookeeperLockUtil.concurrentOperation(new ZookeeperLockUtil.LockCallBall() {
                        @Override
                        public void handle() {
                            //获得了锁, 进行业务流程
                            index++;
                            System.out.println("Enter mutex, time:" + index);
                            if (cacheMap.containsKey(index)) {
                                System.out.println("the concurrent not safe. has the same i:" + index);
                                System.exit(-1);
                            } else {
                                cacheMap.put(index, index);
                            }
                        }
                    }, zkConfig, lockname);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
