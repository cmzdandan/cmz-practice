package com.cmz.string;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 十六进制转十进制
 * <p>
 *  接受一个十六进制的数，输出该数值的十进制表示
 * </p>
 */
public class HexadecimalConvert {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.next();
            String[] strArray = str.split("x",2);
            System.out.println(Integer.parseInt(strArray[1], 16));
        }
    }

}
