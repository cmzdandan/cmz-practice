package com.cmz.prove;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/26
 * @description 验证一个循环的结果
 * <p>
 *  当 i 自增到 Integer.MAX_VALUE时，再加 1，则其值为 Integer.MIN_VALUE 是一个负数
 *  所以，这样便出现了循环永远不能退出，不能结束的情况
 * </p>
 */
public class Loopy {
    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        System.out.println(start);
        final int end = Integer.MAX_VALUE;
        System.out.println(end);
        int count = 0;
        for (int i = start; i <= end; i++) {
            count++;
        }
        System.out.println(count);
    }
}
