package com.cmz.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 字符串切割
 * <p>
 *  连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 *  长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *  输入描述:
 *  连续输入字符串(输入2次,每个字符串长度小于100)
 *
 *  输出描述:
 *  输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
 * </p>
 */
public class StringCut {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (in.hasNext()) {
            String string = in.nextLine();
            if("quit".equals(string)) {
                break;
            }
            while(string.length() >= 8) {
                list.add(string.substring(0, 8));
                string = string.substring(8);
            }
            if(string.length() != 0) {
                int less = 8 - string.length();
                for(int i = 0; i < less; i++) {
                    string += "0";
                }
                list.add(string);
            }
        }
        list.forEach(System.out::println);
    }
}
