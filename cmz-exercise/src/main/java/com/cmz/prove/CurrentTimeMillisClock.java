package com.cmz.prove;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/8/31
 * @description 探寻比System.currentTimeMillis()更高效的方式
 * <p>如何解决System.currentTimeMillis()性能这个问题？最常见的办法是用单个调度线程来按毫秒更新时间戳，相当于维护一个全局缓存。</p>
 * <p>其他线程取时间戳时相当于从内存取，不会再造成时钟资源的争用，代价就是牺牲了一些精确度。</p>
 */
public class CurrentTimeMillisClock {

    private volatile long now;

    private CurrentTimeMillisClock() {
        this.now = System.currentTimeMillis();
        scheduleTick();
    }

    private void scheduleTick() {
        new ScheduledThreadPoolExecutor(1, runnable -> {
            Thread thread = new Thread(runnable, "current-time-millis");
            thread.setDaemon(true);
            return thread;
        }).scheduleAtFixedRate(() -> {
            now = System.currentTimeMillis();
        }, 1, 1, TimeUnit.MILLISECONDS);
    }

    public long now() {
        return now;
    }

    public static CurrentTimeMillisClock getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CurrentTimeMillisClock INSTANCE = new CurrentTimeMillisClock();
    }

}
