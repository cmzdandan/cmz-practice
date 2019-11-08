package com.cmz.gc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/16
 * @description 查看JVM相关参数配置
 * <p>
 *  查看当前进程号  jps -l
 *  查看当前进程的jvm参数配置  jinfo -flags pid
 *  查看当前JDK默认的垃圾收集器 java -XX:+PrintCommandLineFlags -version
 * </p>
 */
public class HelloGC {

    public static void main(String[] args) {
        System.out.println("***** HelloGC *****");
        // 让该程序一直运行不退出，此时我们可以通过控制台查看jvm相关参数
        try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }
        // 先配置 JVM启动参数 -Xms 10m -Xmx 10m ,然后 new 出一个大对象，把内存撑满，这样就会触发 GC
        // byte[] byteArray = new byte[512 * 1024 * 1024];
    }

}
