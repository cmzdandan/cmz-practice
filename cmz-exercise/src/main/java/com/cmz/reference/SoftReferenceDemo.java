package com.cmz.reference;

import java.lang.ref.SoftReference;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description 软引用示例
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        softReferenceMemoryEnougth();
        softReferenceMemoryNotEnougth();
    }

    // 软引用：内存充足的情况(软引用对象不会被回收)
    private static void softReferenceMemoryEnougth() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        // 这样打印出来的，两个地址应该是一样的
        System.out.println(object);
        System.out.println(softReference.get());
        // 经过一次变故：把object指向null，然后垃圾回收
        object = null;
        System.gc();
        /*
         * 再次打印object，此时就能体现软引用，内存够用时，软引用不会被回收
         * 如果调整JVM启动参数，内存不够用则softReference.get()会得到null
         */
        System.out.println(object);
        System.out.println(softReference.get());
    }

    // 软引用：内存不够用的情况(软引用对象会被回收)
    private static void softReferenceMemoryNotEnougth() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        // 这样打印出来的，两个地址应该是一样的
        System.out.println(object);
        System.out.println(softReference.get());
        // 经过一次变故：把object指向null，然后垃圾回收
        object = null;
        try {
            // 故意产生大对象并配置JVM小内存，可以观察到OOM
            byte[] bytes = new byte[50 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(object);
            System.out.println(softReference.get());
        }
    }
}
