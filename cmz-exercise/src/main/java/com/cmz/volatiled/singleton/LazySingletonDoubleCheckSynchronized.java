package com.cmz.volatiled.singleton;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/13
 * @description 懒汉式单例(双端检测再加锁)
 * <p>懒汉式：再需要的时候才初始化</p>
 * <p>
 * 双端加锁，在极端情况下仍然存在线程安全问题
 * 原因：存在着指令重排序。
 * 当某个线程检测当 instance 不为 null 时，此时 instance 的引用对象可能还没有完成初始化；
 * instance = new SingletonInstance(); // 这个代码可以分为下面三步执行
 * memory = allocate(); // 1.分配对象内存空间
 * instance(memory);// 2.初始化对象
 * instance = memory; // 3.设置 instance 指向刚分配的内存地址，此时 instance != null
 * 上面的步骤2，步骤3 不存在数据依赖关系，而且无论是重排前还是重排后程序的执行结果在单线程中并没有改变，因此这种重排优化是允许的。
 * instance = new SingletonInstance(); // 这个代码可以分为下面三步执行
 * memory = allocate(); // 1.分配对象内存空间
 * instance = memory; // 3.设置 instance 指向刚分配的内存地址，此时 instance != null，但是对象还没有完成初始化
 * instance(memory);// 2.初始化对象
 *
 * 指令重排只会保证串行语义的执行的一致性(单线程)，并不会关心多线程间语义的一致性
 * 所以：当一条线程访问instance 不为 null 时，由于 instance 实例未必已经完成初始化，也就造成了线程安全问题。
 * 解决方案：在需要单例的对象的声明前面加上 volatile 关键字
 * </p>
 */
public class LazySingletonDoubleCheckSynchronized {

    private static volatile LazySingletonDoubleCheckSynchronized instance = null;

    private LazySingletonDoubleCheckSynchronized() {
        System.out.println(Thread.currentThread().getName() + "我被初始化了");
    }

    public static LazySingletonDoubleCheckSynchronized getInstance() {
        // 双端检测再加锁，这样的锁粒度更细
        if (instance == null) {
            synchronized (LazySingletonDoubleCheckSynchronized.class) {
                if (instance == null) {
                    instance = new LazySingletonDoubleCheckSynchronized();
                }
            }
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
        for (int i = 0; i < 100; i++) {
            new Thread(() -> LazySingletonDoubleCheckSynchronized.getInstance(), "Thread-" + i).start();
        }
    }
}
