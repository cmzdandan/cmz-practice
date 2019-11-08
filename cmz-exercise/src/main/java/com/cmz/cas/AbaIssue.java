package com.cmz.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description ABA 问题的产生及解决
 */
public class AbaIssue {
    // 创建一个基本的原子引用类型，设置初始值为100
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    // 通过带时间戳的原子引用类型，解决ABA问题(初始值100，初始版本号1)
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("==========以下是ABA问题的产生=========");
        new Thread(() -> {
            // 比较并交换，期望100，改为101
            atomicReference.compareAndSet(100, 101);
            // 比较并交换，期望101，改为100
            atomicReference.compareAndSet(101,100);
        }, "ThreadA").start();
        // 另一个线程，如果上面的操作完全无感知，则出现了ABA问题
        new Thread(() -> {
            // 休眠，是给时间上面的线程完成一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t 获取当前值" + atomicReference.get());
        }, "ThreadB").start();
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("==========以上是ABA问题的产生=========");

        //
        new Thread(() -> {
            // 这里休眠1秒 ，是为了让 ThreadD 线程拿到初始版本号
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            // 比较并交换，每次版本号是在最新的版本号基础上加1
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第2次版本号" + atomicStampedReference.getStamp());
            // 比较并交换，期望101，改为100，版本号再次加1
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第3次版本号" + atomicStampedReference.getStamp());
        }, "ThreadC").start();
        //
        new Thread(() -> {
            // 一开始就拿到版本号
            int stamp = atomicStampedReference.getStamp();
            // 休眠一下，等待 ThreadC 线程把操作执行完，以验证是否还存在ABA问题
            System.out.println(Thread.currentThread().getName() + "\t第1次版本号" + atomicStampedReference.getStamp());
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            // 比较并交换(认为版本号没有被改变，这里还是在当初的版本号上加1)
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t是否修改成功：" + result);
            System.out.println(Thread.currentThread().getName() + "\t 当前实际版本号：" + atomicStampedReference.getStamp());
        }, "ThreadD").start();
    }
}
