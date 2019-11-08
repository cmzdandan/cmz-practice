package com.cmz.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/5/23
 * @description 综合示例：涵盖 volatile,BlockingQueue,多线程
 * <p>需求：一个生产蛋糕，一个消费蛋糕，工商局说不能生产了，生产者停止生产，消费者停止消费。</p>
 */
public class ComprehensiveDemo {

    public static void main(String[] args) {
        // 这个地方的队列大小，就是我们的生产能力了(设置为1，就是生产一个消费一个；设置更大，则是可以生产多个)
        ProducerConsumer producerConsumer = new ProducerConsumer(new ArrayBlockingQueue<>(1));
        new Thread(()->{
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Producer").start();

        new Thread(()->{
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();
        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工商局叫停生产");
        producerConsumer.stop();
    }

}

class ProducerConsumer {

    // 多线程操作资源类，共享变量必须用volatile保证可见性
    private volatile boolean FLAG = true;// 默认情况下，可以生产
    // 通过这里复习原子类操作(用它作为生产者的原材料)
    private AtomicInteger atomicInteger = new AtomicInteger();
    // 生产的内容放进一个阻塞队列中,默认为null，是一个接口，把具体类型留给调用者
    private BlockingQueue<String> blockingQueue = null;
    // 通过构造函数进行接口注入(依赖注入的方式：1.set方法；2.构造函数传接口的实现类实例)
    public ProducerConsumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        // 实际生产中，一般都会打印日志，是谁调用了这个构造函数，入参是什么(通过反射得到全类名)
        System.out.println(blockingQueue.getClass().getName());
    }

    // 生产的方法
    public void produce() throws InterruptedException {
        // 将这些声明都放在外面复用，以免循环里面重新造成新的变量
        String data = null;
        boolean result = false;
        // 1.判断
        while(FLAG) {
            // 2. 干活儿
            // atomicInteger 默认值是0，getAndIncrement()相当于 i++，首先获得的还是0；incrementAndGet() 相当于 ++i
            data = atomicInteger.incrementAndGet() + "";
            // 将生产的内容放入到阻塞队列(实际生产中，都是用下面这种构造函数的队列，要设定一个超时时间)
            result = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(result) {
                System.out.println("Producer offer data : " + data);
            } else {
                System.out.println("Producer offer data fail.");
            }
            // 干活不会那么快，休眠一下来模拟1秒生产一个
            TimeUnit.SECONDS.sleep(2L);
        }
        System.out.println("工商局叫停了，不能生产了");
    }

    public void consume() throws InterruptedException {
        String result = null;
        // 1.判断
        while(FLAG) {
            result = blockingQueue.poll(3L, TimeUnit.SECONDS);
            if(result == null || "".equals(result)) {
                FLAG = false;
                System.out.println("超过3秒没有吃到蛋糕，停止消费了");
                // 这里一定要加上return，否则，下面的蛋糕就要被多吃一次了
                return;
            }
            System.out.println("吃到蛋糕了，好开心哦！");
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}