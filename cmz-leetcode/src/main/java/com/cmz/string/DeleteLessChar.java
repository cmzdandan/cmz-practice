package com.cmz.string;

import java.util.*;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/18
 * @description 删除字符串中出现的次数最少的字符
 * <p>
 *  实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 *  输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *  示例1
 * 输入
 * abcdd
 * 输出
 * dd
 * </p>
 */
public class DeleteLessChar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.nextLine();
            System.out.println(deleteLessetChar(string));
        }
    }

    private static String deleteLessetChar(String string) {
        if(null == string || string.length() == 0) {
            return string;
        }
        char[] chars = string.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : chars) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Collection<Integer> values = map.values();
        Integer min = Collections.min(values);
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            if(map.get(c) != min) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
