package com.cmz.string;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写
 */
public class CountChar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            String c = in.nextLine().toLowerCase();
            char temp = c.charAt(0);
            char[] chars = str.toLowerCase().toCharArray();
            int count = 0;
            for(char ch : chars) {
                if(temp == ch) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
