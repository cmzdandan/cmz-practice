package com.cmz.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/10
 * @description Semaphore Demo
 * <p>信号量：常用于限制可以访问某些资源的线程数量</p>
 * <p>可以理解为：我们的停车场最多允许停 5 辆车，那么当 semaphore.acquire() 发放完毕，其他的车辆进入不了(线程就阻塞)</p>
 * <p>当有车辆离开时会归还停车卡 semaphore.release()，此时阻塞的就可以被唤醒，可以继续进入停车场</p>
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，只允许 3个线程同时访问
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            final long num = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可(拿到停车卡)
                        semaphore.acquire();
                        // do something
                        System.out.println("Accessing: " + num);
                        Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
                        // 释放许可(还回停车卡)
                        semaphore.release();
                        System.out.println("Release..." + num);
                    } catch (InterruptedException  e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
