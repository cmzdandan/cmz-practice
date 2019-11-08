package com.cmz.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/9
 * @description CountDownLatchDemo
 */
public class CountDownLatchDemo extends Thread {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new CountDownLatchDemo().start();
        }
        countDownLatch.countDown();
    }
}
