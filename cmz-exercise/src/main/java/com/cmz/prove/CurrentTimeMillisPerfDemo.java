package com.cmz.prove;

import java.util.concurrent.CountDownLatch;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/8/31
 * @description 系统时间性能测试
 * <p>System.currentTimeMillis()是极其常用的基础Java API，广泛地用来获取时间戳或测量代码执行时长等，在我们的印象中应该快如闪电。</p>
 * <p>但实际上在并发调用或者特别频繁调用它的情况下（比如一个业务繁忙的接口，或者吞吐量大的需要取得时间戳的流式程序），其性能表现会令人大跌眼镜。</p>
 */
public class CurrentTimeMillisPerfDemo {

    private static final int COUNT = 100;

    public static void main(String[] args) throws Exception {
        long beginTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            System.currentTimeMillis();
        }

        long elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() serial calls: " + elapsedTime + " ns");

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            new Thread(() -> {
                try {
                    startLatch.await();
                    System.currentTimeMillis();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endLatch.countDown();
                }
            }).start();
        }

        beginTime = System.nanoTime();
        startLatch.countDown();
        endLatch.await();
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() parallel calls: " + elapsedTime + " ns");
    }

}
