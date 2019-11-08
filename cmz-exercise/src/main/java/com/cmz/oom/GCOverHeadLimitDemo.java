package com.cmz.oom;

import java.util.*;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/20
 * @description GC overhead limit exceeded示例
 * <p>
 *  先将堆空间调小，再进行不断的创建新的对象
 *  -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=2m -XX:+UseGCOverheadLimit
 *  Sun 官方对此的定义：超过98%的时间用来做GC并且回收了不到2%的堆内存时会抛出此异常。
 *  GC回收时间过长会抛出OutOfMemoryError，过长的定义是，超过98%的时间都是用来做GC，并且回收了不到2%的堆内存
 *  连续多次GC都只回收了不到2%的极端情况下才会抛出。假如不抛出  GC overhead limit 错误会发生什么情况呢？
 *  那就是 GC 清理的这么一点内存会很快再次填满，迫使 GC 再次执行，这样就形成了恶性循环。
 *  CPU 使用率一直是 100% ，而 GC 却没有任何成果
 * </p>
 */
public class GCOverHeadLimitDemo {
    public static void main(String[] args) {
        addRandomDataToMap();
    }

    public static void addRandomDataToMap() {
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        while (true) {
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
        }
    }
}
