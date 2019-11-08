package com.cmz.array;

import java.util.*;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 数组去重排序
 * <p>
 *  明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 *  对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 *  然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 *  请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * </p>
 */
public class DistinctAndSortArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int count = 0;
            Set<Integer> set = new HashSet<>();
            while(count < n) {
                set.add(in.nextInt());
                count++;
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            list.forEach(System.out::println);
        }
        in.close();
    }
}
