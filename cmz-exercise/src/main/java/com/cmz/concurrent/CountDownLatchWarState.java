package com.cmz.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/10
 * @description 战国七雄演绎 CountDownLatch 的使用
 * <p>CountDownLatch：让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒</p>
 * <p>CountDownLatch主要有两个方法，当一个线程或者多个线程调用await方法时，调用线程会被阻塞。</p>
 * <p>其他线程调用countDown方法会将计数器减1（调用countDown方法的线程不会阻塞）</p>
 * <p>当计数器为0时，因调用await方法被阻塞的线程会被唤醒继续执行。</p>
 */
public class CountDownLatchWarState {

    private final static int COUNTRY_COUNT = 6;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(COUNTRY_COUNT);
        for(int i = 1; i <= COUNTRY_COUNT; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " die out");
                countDownLatch.countDown();
            }, CountryEnum.getCountry(i).getMessage()).start();
        }
        countDownLatch.await();
        System.out.println("秦灭六国，统一天下");
    }

}
