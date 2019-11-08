package com.cmz.oom;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description JavaHeapSpace示例
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        // 创建一个大对象，设置JVM启动参数很小  -Xms5m -Xmx5m
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        byte[] bytes = new byte[5 * 1024 * 1024];
        System.out.println(bytes);
    }
}
