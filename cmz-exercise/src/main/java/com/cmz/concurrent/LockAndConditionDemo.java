package com.cmz.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/5/22
 * @description Lock 和 Condition 示例
 * <p>需求：A、B、C 三个线程，A打印5次，B打印10次，C打印15次，这样依次来10轮</p>
 * <p>线程    操作  资源类</p>
 * <p>定义一个资源类，自带三种打印方法，并且是精确唤醒其他线程</p>
 * <p>A执行完了唤醒B，B执行完了唤醒C，C执行完了唤醒A</p>
 */
public class LockAndConditionDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"C").start();
    }

}

/**
 * 资源类，自带各种同步方法
 */
class ShareResource {
    // 定义一个判断标识
    private int number = 1;
    // 定义一个锁
    private Lock lock = new ReentrantLock();
    // 定义三个条件唤醒信号
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try{
            // 判断
            while(number != 1) {
                condition1.await();
            }
            // 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 改变条件判断标识然后精准唤醒其他线程[这一步极为重要]
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try{
            // 判断
            while(number != 2) {
                condition2.await();
            }
            // 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 改变条件判断标识然后精准唤醒其他线程[这一步极为重要]
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try{
            // 判断
            while(number != 3) {
                condition3.await();
            }
            // 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 改变条件判断标识然后精准唤醒其他线程[这一步极为重要]
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}