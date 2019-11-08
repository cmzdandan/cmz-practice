package com.cmz.volatiled.singleton;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/13
 * @description 饿汉式单例
 * <p>
 * 单例套路：
 * 1.私有的静态成员变量；
 * 2.私有化构造器；
 * 3.提供公共的静态访问方法；
 * </p>
 */
public class HungrySingleton {
    // 1.私有的静态成员变量；
    private static HungrySingleton instance = new HungrySingleton();

    // 2.私有化构造器
    private HungrySingleton() {
        System.out.println(Thread.currentThread().getName() + "我被初始化了");
    }

    // 3.对外提供公共的访问方式
    public static HungrySingleton getInstance() {
        return instance;
    }

    // 验证单例
    public static void main(String[] args) {
        // 单线程下，只会初始化一次
//        System.out.println(HungrySingleton.getInstance());
//        System.out.println(HungrySingleton.getInstance());
//        System.out.println(HungrySingleton.getInstance());
        // 多线程下，饿汉式也只初始化一次
        for(int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(HungrySingleton.getInstance()), "Thread-" + i).start();
        }
    }
}
