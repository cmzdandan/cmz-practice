package com.cmz.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/10
 * @description CyclicBarrierDemo
 * <p>它主要做的事情是，让一组线程达到一个屏障（也可以叫同步点）时被阻塞[线程通过CyclicBarrier的await方法进入屏障]</p>
 * <p>直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活</p>
 */
public class CyclicBarrierDemo {

    private final static int DRONGON_BALL_COUNT = 7;

    public static void main(String[] args) {
        // 设置栅栏(任务完成后的汇合地点)目标，集齐 7 颗龙珠，然后：打印召唤神龙
        CyclicBarrier cyclicBarrier = new CyclicBarrier(DRONGON_BALL_COUNT, () -> System.out.println("集齐七颗龙珠，召唤神龙"));

        for (int i = 1; i < 8; i++) {
            final int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集到了" + finalI + "号龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i).start();
        }

    }

}
