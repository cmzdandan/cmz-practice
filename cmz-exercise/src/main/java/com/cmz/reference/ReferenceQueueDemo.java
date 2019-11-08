package com.cmz.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description 引用队列示例
 * <p>
 *  被设置为弱引用的对象，gc之前 ReferenceQueue 为 null，gc之后不为 null
 * </p>
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(object, referenceQueue);

        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("------------------------------");

        object = null;
        System.gc();
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
