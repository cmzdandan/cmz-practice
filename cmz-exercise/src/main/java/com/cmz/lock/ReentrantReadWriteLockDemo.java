package com.cmz.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description 可重入的读写锁示例
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        // 首先 new 一个资源类出来
        MyCache myCache = new MyCache();
        // 5 个线程写入
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> myCache.put(finalI + "", finalI + ""), "Thread-" + i).start();
        }
        // 5 个线程读取
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> myCache.get(finalI + ""), "Thread-" + i).start();
        }
    }
}

// 高内聚、低耦合、线程操作资源类
class MyCache {
    // 缓存的底层原理：Map，读操作、写操作、清空操作
    private volatile Map<String, Object> map = new ConcurrentHashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        // 写操作，专门加写锁，独占锁，将业务操作代码放入锁的代码块中
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写入：" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        // 读操作，专门加读锁，共享锁，将业务代码放入锁的代码块中
        lock.readLock().lock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + " 正在读取：");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完成：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return result;
    }

    public void clear() {
        map.clear();
    }
}