package com.cmz.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description 自旋锁示例
 * <p>
 * 自旋锁的本质：while循环 加 cas (compareAndSet)
 * </p>
 */
public class SpinLockDemo {
    // 原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        // 拿到当前线程，用于自旋比较
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " come in ...");
        // 这个自旋：在比较成功的时候会返回true，前面取反才能跳出循环
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        // 期望比较的是当前线程，将其置为null，则释放锁了(释放锁无需自旋)
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnLock();
            System.out.println(Thread.currentThread().getName() + " give up the lock ...");
        }, "ThreadA").start();
        // 这里先休眠1秒，确保ThreadA能够先获得锁，下面再进入 ThreadB
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnLock();
            System.out.println(Thread.currentThread().getName() + " give up the lock ...");
        }, "ThreadB").start();
    }
}