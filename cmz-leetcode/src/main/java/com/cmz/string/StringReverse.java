package com.cmz.string;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/18
 * @description 字符串反转
 * <p>
 *  写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串
 * </p>
 */
public class StringReverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            System.out.println(reverse(string));
           // string = reverse(string);
            //System.out.println(string);
        }
    }

    private static String reverse(String string) {
        if(null == string) {
            return null;
        }
        if(string.length() == 0) {
            return string;
        }
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length; i > 0; i--) {
            sb.append(chars[i - 1]);
        }
        return sb.toString();
    }

}
