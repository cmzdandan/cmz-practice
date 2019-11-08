package com.cmz.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description synchronized 是一个典型的可重入锁的验证
 * <p>
 * 可重入锁：同一线程外层方法获取锁后，内层递归调用的方法仍自动获取这把锁
 * </p>
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> phone.sendMsg(), "t1").start();
        new Thread(() -> phone.sendMsg(), "t2").start();
        new Thread(() -> phone.sendMsg(), "t3").start();
        new Thread(() -> phone.sendMsg(), "t4").start();
    }
}

class Phone {
    // 发短信方法上加锁了，内部调用了打电话方法(这两段会一起执行，中间不会被插队)
    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "发短信了");
        makeCall();
    }

    // 打电话方法会自动获得发短信方法的锁(这就是可重入锁)
    public void makeCall() {
        System.out.println(Thread.currentThread().getName() + "发打电话了");
    }
}