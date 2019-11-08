package com.cmz.oom;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/20
 * @description java.lang.OutOfMemoryError:Direct buffer memory
 * <p>
 * 配置JVM启动参数，模拟直接内存被撑爆的现象
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m -XX:+UseGCOverheadLimit
 * JVM运行在物理内存之上，GC回收的都是 JVM 里面的内存。介于物理内存和JVM内存之间的就是直接内存(即：直接物理内存)
 * 如果在直接内存上分配空间，再不受JVM管理，也就不会被GC回收掉。直接与物理内存交互，省去了JVM内存中的拷贝，效率高。
 *
 * 故障现象：
 * Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 * 导致原因：
 * 写NIO程序经常使用 ByteBuffer 来读取或写入数据，这是一种基于通道(Channel)与缓冲区(Buffer)的 I/O 方式，
 * 它可以使用 Native 函数库直接分配堆外内存，然后通过一个存储在 Java 堆里面的 DirectByteBuffer 对象作为这块内存的引用进行操作。
 * 这样能在一些场景中显著提高性能，因为避免了在 Java堆 和 Native 堆中来回复制数据。
 *
 * ByteBuffer.allocate(capability) 这种方式是分配 JVM 堆内存，属于 GC 管辖范围，由于需要拷贝所以速度相对较慢。
 * ByteBuffer.allocateDirect(capability) 这种方式是分配 OS 本地内存，不属于GC管辖范围，不需要内存拷贝所以速度快。
 *
 * 但是，如果不断的分配本地内存，堆内存很少使用 ，那么JVM就不需要执行GC，DirectByteBuffer对象就不会被回收
 * 这时候堆内存充足，但是本地内存可能已经用光了，再次尝试 分配本地内存就会 出现 OutOfMemoryError，那程序就直接崩溃了。
 * </p>
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory: " + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "Mb");
        // 休眠一下，便于打印直接内存
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 通过 nio 方式在直接内存中分配空间，超过最大可用的直接内存，则报直接内存溢出
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
        System.out.println(byteBuffer);
    }
}
