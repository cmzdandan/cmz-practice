package com.cmz.volatiled.singleton;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/13
 * @description 懒汉式单例
 * <p>懒汉式：再需要的时候才初始化</p>
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
        System.out.println(Thread.currentThread().getName() + "我被初始化了");
    }

    public static LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // 验证恶汉式单例
    public static void main(String[] args) {
        // 单线程情况下，只会初始化一次
//        System.out.println(LazySingleton.getInstance());
//        System.out.println(LazySingleton.getInstance());
//        System.out.println(LazySingleton.getInstance());
        // 多线程情况下，就很可能不是初始化一次了
        for(int i = 0; i < 10; i++) {
            new Thread(() -> LazySingleton.getInstance(), "Thread-" + i).start();
        }
    }
}
