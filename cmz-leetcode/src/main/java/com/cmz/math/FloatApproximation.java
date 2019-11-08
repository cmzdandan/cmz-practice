package com.cmz.math;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 浮点数近似值
 * <p>
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * </p>
 */
public class FloatApproximation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double num = in.nextDouble();
            int round = (int) Math.round(num);
            System.out.println(round);
        }
    }

}
