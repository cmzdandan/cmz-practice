package com.cmz.collection;

import java.util.*;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/18
 * @description 单词排序
 * <p>
 *  给定n个字符串，请对n个字符串按照字典序排列。
 *  输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 * </p>
 */
public class WordsSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int num = in.nextInt();
            int count = 0;
            List<String> list = new ArrayList<>();
            while(count <= num) {
                String word = in.nextLine();
                list.add(word);
                count++;
            }
            Collections.sort(list);
            // list.forEach(System.out::println);
            for(int i = 0; i < list.size(); i++) {
                if(i + 1  ==  list.size()) {
                    System.out.print(list.get(i));
                } else {
                    System.out.println(list.get(i));
                }
            }
        }
    }

}
