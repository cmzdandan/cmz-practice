package com.cmz.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/5/15
 * @description 阻塞队列示例
 * <p>当阻塞队列是空时，从队列获取元素的操作会被阻塞</p>
 * <p>当阻塞队列是满时，往队列插入元素的操作会被阻塞</p>
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        // add() remove()方法，失败报异常
        System.out.println(blockingQueue.add("aaa"));// 返回布尔值，插入失败报异常(队列满了就插不进去)
        System.out.println(blockingQueue.remove());// 返回布尔值，可传参数也可以不传参，不传参删除第一个；传参删除指定元素(元素不存在就报异常)
        // offer() poll()方法，不会报异常
        System.out.println(blockingQueue.offer("bbb"));// 返回布尔值
        System.out.println(blockingQueue.poll());// 返回布尔值
        // put() take()方法，插入和取出元素，会产生阻塞。元素不存在时取不到就阻塞；队列满时插入元素就阻塞
        blockingQueue.put("ccc");
        blockingQueue.take();
        // offer(e,time,unit) take(e,time,unit) 过时不候，不会报异常
        blockingQueue.offer("ddd", 5, TimeUnit.SECONDS);// 5秒钟过时不候
        blockingQueue.poll(5, TimeUnit.SECONDS);// 5秒钟过时不候
    }

}
