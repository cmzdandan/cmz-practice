package com.cmz.reference;

import java.lang.ref.WeakReference;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description 弱引用示例
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object object = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object);
        System.out.println(object);
        System.out.println(weakReference.get());
        // 此时制造一点变故，将object置为null
        object = null;
        System.gc();
        // 再次打印，经过GC，弱引用会被回收，两个打印都是null
        System.out.println(object);
        System.out.println(weakReference.get());
    }
}
