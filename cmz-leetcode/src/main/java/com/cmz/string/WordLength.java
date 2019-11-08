package com.cmz.string;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 一段字符串中最后一个单词的长度
 */
public class WordLength {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";
        while(in.hasNext()) {
            str = in.nextLine();
            str = str.substring(str.lastIndexOf(" ") + 1);
            System.out.println(str.length());
        }
        in.close();
    }

}
