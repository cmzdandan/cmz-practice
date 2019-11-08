package com.cmz.collection;

import java.util.*;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 反转正正数
 * <p>
 *  输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * </p>
 */
public class ReverseInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int num = in.nextInt();
            List<String> list = new ArrayList<>();
            String numStr = String.valueOf(num);
            for(int i = numStr.length(); i > 0; i--) {
                String c = String.valueOf(numStr.charAt(i - 1));
                if(list.contains(c)) {
                    continue;
                }
                list.add(c);
            }
            list.forEach(System.out::print);
        }
    }

}
