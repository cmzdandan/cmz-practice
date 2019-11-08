package com.cmz.string;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/18
 * @description 反转英文语句
 * <p>
 *  将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *  所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * </p>
 */
public class ReverseSentence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String sentence = in.nextLine();
            System.out.println(reverseSentence(sentence));
        }
    }

    private static String reverseSentence(String sentence) {
        if(null == sentence || sentence.length() == 0) {
            return sentence;
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length; i > 0; i--) {
            sb.append(words[i - 1]).append(" ");
        }
        String temp = sb.toString();
        return temp.substring(0, temp.length() - 1);
    }

}
