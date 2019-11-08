package com.cmz.math;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/18
 * @description 统计一个正整数转换为二进制数后包含的 1 的个数
 */
public class CountOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            //java API中有方法可以直接十进制转二进制
            String string = Integer.toBinaryString(num);
            int count = 0;
            for(int i = 0; i < string.length(); i++) {
                if(string.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
