package com.cmz.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/9
 * @description Study Condition wait 方法
 */
public class ConditionDemoWait implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionDemoWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("Begin ConditionDemoWait");
        try {
            lock.lock();
            condition.await();
            System.out.println("End ConditionDemoWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
