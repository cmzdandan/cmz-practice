package com.cmz.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 统计字符个数
 * <p>
 *  编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 * </p>
 */
public class CharCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String string = in.nextLine();
            char[] chars = string.toCharArray();
            // 要注意去重
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < chars.length; i++) {
                if(0 <= chars[i] && chars[i] <= 127) {
                    set.add(chars[i]);
                }
            }
            System.out.println(set.size());
        }
    }

}
