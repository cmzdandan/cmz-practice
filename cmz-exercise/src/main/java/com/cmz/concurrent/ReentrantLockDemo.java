package com.cmz.concurrent;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/6
 * @description 学习ReentrantLock相关知识
 * <p>可重入锁</p>
 */
public class ReentrantLockDemo {

    public synchronized void demo1(){
        System.out.println("begin:demo1");
        demo2();
    }

    public void demo2(){
        System.out.println("begin:demo2");
        synchronized (this){
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo rl = new ReentrantLockDemo();
        new Thread(rl::demo1).start();
    }

}
