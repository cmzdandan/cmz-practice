package com.cmz.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/5/21
 * @description 传统版生产者消费者
 * <p>线程    操作      资源类</p>
 * <p>1.创建资源类；2.提供被操作的方法；3.创建线程操作资源类</p>
 * <p>判断    干活      通知</p>
 * <p>1.判断是否轮到自己干活；2.执行干活儿逻辑；3.干完活儿唤醒其他线程</p>
 * <p>防止虚假唤醒机制</p>
 * <p>wait(),notify()都是Object内的方法，在API文档中有提到虚假唤醒，所以，判断必须用while来判断</p>
 */
public class ProducerConsumerTraditional {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.increase();
            }
        },"Thread-AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.decrease();
            }
        },"Thread-BB").start();
    }
}

/**
 * 资源类
 * 被多线程操作，需要提供同步方法
 */
class ShareData {
    private int number = 0;
    // 多线程操作同一份资源必然有争抢，必须加锁
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 对外提供操作资源类的方法
    public void increase() {
        lock.lock();
        try{
            // 1.判断，不符合条件就等待，多线程只能用while判断
            while(number != 0) {
                condition.await();
            }
            // 2.干活，当前number为0，可以进行加操作
            number++;
            System.out.println(number);
            // 3.唤醒其他线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() {
        lock.lock();
        try{
            // 1.判断
            while(number == 0) {
                condition.await();
            }
            // 2.干活
            number--;
            System.out.println(number);
            // 3.唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}