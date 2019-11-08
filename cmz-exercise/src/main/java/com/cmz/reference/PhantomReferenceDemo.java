package com.cmz.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description 虚引用示例
 * <p>
 *  被设置为虚引用的对象，gc之前 ReferenceQueue 为 null，gc之后不为 null
 *
 *  创建引用的时候可以指定关联队列，当 GC 释放对象内存的时候，会将引用加入到引用对象；
 *  如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动，这相当于一种通知机制
 *
 *  当关联的引用队列中有数据的时候，意味着引用指向的堆内存中的对象被回收。
 *  通过这种方式，JVM允许我们在对象被销毁之后，做一些我们想做的事情。
 * </p>
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object, referenceQueue);

        System.out.println(object);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("------------------------------");

        object = null;
        System.gc();
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(object);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }
}
