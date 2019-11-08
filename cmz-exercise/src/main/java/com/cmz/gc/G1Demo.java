package com.cmz.gc;

import java.util.Random;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/22
 * @description 演示G1垃圾回收器
 * <p>
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 * </p>
 */
public class G1Demo {
    public static void main(String[] args) {
        String string = "cmz";
        while(true) {
            // 不停的产生新的对象
            string += new Random().nextInt(1111111111) + new Random().nextInt(222222222);
            string.intern();
        }
    }
}
