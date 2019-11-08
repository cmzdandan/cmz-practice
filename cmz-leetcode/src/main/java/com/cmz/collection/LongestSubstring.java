package com.cmz.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/12
 * @description 最长子串
 * <p>给定一个字符串，请你找出其中不含有重复字符的“最长子串”的长度。</p>
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * <p>
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * </p>
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String string = "abcabcbb";
        int length = lengthOfLongestSubstring(string);
        System.out.println(length);
    }

    /**
     * 解法一
     * <p>什么是滑动窗口？其实就是一个队列。</p>
     * <p>比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。</p>
     * <p>所以，我们要移动这个队列！如何移动？</p>
     * <p>我们只要把队列的左边的元素移出就行了，直到满足题目要求！</p>
     * <p>一直维持这样的队列，找出队列出现最长的长度时候，求出解！</p>
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * 解法二
     * <p>维持一个左子针left和一个右子针right。right-left就是无重复子串的长度。</p>
     * <p>遍历规律为：没有重复的话，right向右移动一位；</p>
     * <p>有重复的话，left右移并更新最长字符串max的值，右移一直到滑动窗口内无重复字符。即tmp[s.charAt(r)] == 0</p>
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] tmp = new int[256];
        int maxlen = 0;
        int l = 0;
        int r = 0;

        while (l < s.length()) {
            if (r < s.length() && tmp[s.charAt(r)] == 0) {
                tmp[s.charAt(r++)] = 1;
            } else {
                maxlen = maxlen > (r - l) ? maxlen : (r - l);
                tmp[s.charAt(l++)] = 0;
            }
        }
        return maxlen;
    }

    /**
     * 解法三
     * <p>滑动找到所有不重复的子字符串，如果长度最长，记录为最长字符串</p>
     * <p>
     * 1.遍历数组，第一个不重复子字符串为最长字符串
     * 2.如果当前字符不存在于子字符串，加入子字符串，如果当前字符串长度大于最长字符串，当前字符串设为最长字符串
     * 3.如果存在，则去除子字符串中当前字符及以前的字符，继续遍历
     * </p>
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        char[] arr = s.toCharArray();
        int maxLength = 0; // 最长不重复字符串长度
        List<Character> list = new ArrayList<>(); // 当前相连不重复字符串
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
                if (list.size() >= maxLength) {
                    maxLength = list.size();
                }
            } else {
                int index = list.indexOf(arr[i]);
                List<Character> needToRemoveChar = list.subList(0, index + 1);
                list.removeAll(needToRemoveChar);
                list.add(arr[i]);
            }
        }
        return maxLength;
    }
}
