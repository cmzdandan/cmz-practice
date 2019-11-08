package com.cmz.volatiled.singleton;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/13
 * @description 懒汉式单例(获取实例的方法上加锁)
 * <p>懒汉式：再需要的时候才初始化</p>
 */
public class LazySingletonSynchronized {
    private static LazySingletonSynchronized instance = null;

    private LazySingletonSynchronized() {
        System.out.println(Thread.currentThread().getName() + "我被初始化了");
    }

    public static synchronized LazySingletonSynchronized getInstance() {
        if(instance == null) {
            instance = new LazySingletonSynchronized();
        }
        return instance;
    }

    // 验证恶汉式单例
    public static void main(String[] args) {
        // 单线程情况下，只会初始化一次
//        System.out.println(LazySingleton.getInstance());
//        System.out.println(LazySingleton.getInstance());
//        System.out.println(LazySingleton.getInstance());
        // 多线程情况下，就很可能不是初始化一次了(加锁可以解决线程不安全的问题)
        for(int i = 0; i < 100; i++) {
            new Thread(() -> LazySingletonSynchronized.getInstance(), "Thread-" + i).start();
        }
    }
}
