package com.cmz.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/9
 * @description Study Condition Signal
 */
public class ConditionDemoSignal implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionDemoSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin - ConditionDemoSignal");
        try {
            lock.lock();
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
