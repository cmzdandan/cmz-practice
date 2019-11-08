package com.cmz.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description ReentrantLock 是一个典型的可重入锁的验证
 * <p>
 *  可重入锁：同一线程外层方法获取锁后，内层递归调用的方法仍自动获取这把锁
 * </p>
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        for(int i = 0; i < 3; i++) {
            new Thread(computer, "thread-" + i).start();
        }
    }
}

class Computer implements Runnable {

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        music();
    }

    public void music() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "用电脑听歌");
            movie();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void movie() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "用电脑看电影");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}