package com.cmz.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/5/21
 * @description Synchronous队列示例
 * <p>这种队列是一对一的关系，生产一个消费一个，队列不存储元素</p>
 * <p>如果生产的没有被消费则不会生产下一个，一旦消费则会立即生产下一个</p>
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try{
                // 此线程连续put3个元素，下面验证，如果没有立即消费，不会立即生产
                System.out.println("Current thread: " + Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println("Current thread: " + Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println("Current thread: " + Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }, "Thread-A").start();
        //*********************************************************
        new Thread(() -> {
            try{
                // 此线程每隔5秒take走1个元素，下面验证，如果没有立即消费，不会立即生产
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Current thread: " + Thread.currentThread().getName() + "\t take 1");
                blockingQueue.take();
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Current thread: " + Thread.currentThread().getName() + "\t take 2");
                blockingQueue.take();
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Current thread: " + Thread.currentThread().getName() + "\t take 3");
                blockingQueue.take();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }, "Thread-B").start();
    }

}