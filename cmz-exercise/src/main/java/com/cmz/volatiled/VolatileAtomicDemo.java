package com.cmz.volatiled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/11
 * @description 验证volatile不保证原子性
 * <p>volatile可以保证可见性，但是不保证原子性</p>
 * <p>原子性：完整性，不可分割。即：某个线程正在执行某个操作不允许被中断或者说不允许被分割。</p>
 * <p>要么同时成功，要么同时失败。(某种意义上说，也算是最终一致性)</p>
 */
public class VolatileAtomicDemo {

    public static void main(String[] args) {
        // 线程操作资源类，先把资源类对象准备好
        MyData myData = new MyData();
        // 例如我有20个线程，每个线程操作1000次 addPlusPlus() 方法。如果结果是20000则说明保证原子性，否则不保证原子性；
        for(int i = 0; i < 20; i++) {
            new Thread(() -> {
                for(int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, "Thread-" + i).start();
        }
        // 优雅的等待所有的线程执行完毕
        while (Thread.activeCount() > 2) {
            // 默认后台肯定有两个线程在运行：main线程和 GC线程，如果线程数大于2，则说明刚刚的20个线程有没有跑完的
            // 此刻调用 yield()方法，主动让出cpu的执行权，其他线程可以继续工作
            Thread.yield();
        }
        // 打印最终的计算结果，验证是否保证原子性
        System.out.println(Thread.currentThread().getName() + " int type finally the result is :" + myData.number);
        System.out.println(Thread.currentThread().getName() + " AtomicInteger finally the result is :" + myData.atomicInteger);
    }

}

class MyData {
    // volatile 不保证原子性
    volatile int number = 0;

    public void addPlusPlus() {
        number++;
    }

    // AtomicInteger 保证原子性，构造函数不传参数，默认值为0
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}