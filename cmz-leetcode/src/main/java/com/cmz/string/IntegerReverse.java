package com.cmz.string;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 整数逆序输出
 * <p>
 *  输入一个整数，将这个整数以字符串的形式逆序输出,程序不考虑负数的情况，
 *  若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * </p>
 */
public class IntegerReverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            String numStr = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            char[] chars = numStr.toCharArray();
            for(int i = chars.length; i > 0; i--) {
                sb.append(chars[i - 1]);
            }
            System.out.println(sb.toString());
        }
    }

}
