package com.cmz.oom;

import java.util.concurrent.TimeUnit;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/20
 * @description java.lang.OutOfMemoryError:unable to create new native thread
 * <p>
 * 故障现象：
 * java.lang.OutOfMemoryError:unable to create new native thread
 * 异常分析：
 * 高并发请求服务器时，经常出现如下异常 java.lang.OutOfMemoryError: unable to create new native thread
 * 准确的讲，该 native thread 异常与对应的平台有关
 * 1.创建了太多的线程，一个应用进程创建多个线程，超过了系统承载的极限；
 * 2.服务器并不允许应用创建这么多线程，Linux系统默认允许单个进程可以创建的线程数是1024个(root用户无上限)，
 * 如果我们的应用创建的线程数超过了这个数量，就会报  java.lang.OutOfMemoryError: unable to create new native thread
 *
 * 解决方案：
 * 1.想办法降低应用程序创建线程的数量，分析应用是否真的需要创建这么多线程，如果不是，则调整 代码降低线程数量；
 * 2.对于确实需要创建这么多线程的应用，远超过Linux系统的默认1024个线程的限制，可以修改Linux系统配置，扩大限制
 * vim /etc/security/limits.d/90-nproc.conf
 * </p>
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        // 不停的创建新的线程(没有写上限)
        for(int i = 0; ; i++) {
            System.out.println("########## " + i);
            new Thread(() -> {
                // 每个创建出来的线程都一直存活
                try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }
            }, "Thread-" + i).start();
        }
    }
}
