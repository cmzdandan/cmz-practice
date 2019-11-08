package com.cmz.array;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 求一个数的质数因子
 * <p>
 *  输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）最后一个数后面也要有空格
 *  函数接口说明：
 *  public String getResult(long ulDataInput)
 *
 * 输入参数：
 * long ulDataInput：输入的正整数
 *
 * 返回值：
 * String
 *
 * 输入
 * 180
 * 输出
 * 2 2 3 3 5
 * </p>
 */
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            long num = in.nextLong();
            System.out.println(getResult(num));
        }
    }

    public static String getResult(long ulDataInput) {
        StringBuilder sb = new StringBuilder();
        int k = 2;
        while(ulDataInput != 1) {
            if(ulDataInput % k == 0) {
                ulDataInput /= k;
                sb.append(k).append(" ");
            } else {
                k++;
            }
        }
        return  sb.toString();
    }
}
