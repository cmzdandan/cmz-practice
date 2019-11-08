package com.cmz.singleton;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/17 0017
 * @description 懒汉式单例(无锁)
 * 优点:
 * 由于懒汉式延时加载特性，使用该实例时才实例化，节省了内存资源
 * 缺点：
 * (1) 该种实现方式存在线程不安全问题
 * (2) 反序列化，反射与克隆可破坏单例
 */
public class LazySingletonWithoutSync {

    /**
     * 私有化构造器
     */
    private LazySingletonWithoutSync() {}

    /**
     * 声明静态的类对象
     */
    private static LazySingletonWithoutSync instance;

    /**
     * 提供公共的静态获取该类对象的方法
     */
    public static LazySingletonWithoutSync getInstance() {
        if(instance == null) {
            instance = new LazySingletonWithoutSync();
        }
        return instance;
    }
}
