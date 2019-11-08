package com.cmz.game;

import java.util.Scanner;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 扑克牌游戏
 */
public class PalyCard {
    public static String poker = "345678910JQKA2jokerJOKER";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            if(s.contains("joker JOKER")) {
                System.out.println("joker JOKER");
            } else {
                String[] str = s.split("\\-");
                //\\s表示   空格,回车,换行等空白符
                String[] left = str[0].split("\\s");
                String[] right = str[1].split("\\s");
                if(left.length == 4 && right.length != 4) {
                    System.out.println(str[0]);
                } else if(left.length != 4 && right.length == 4) {
                    System.out.println(str[1]);
                } else if(left.length == right.length) {
                    //之所以定义poker,是保证牌的大小
                    String larger = poker.indexOf(left[0]) > poker.indexOf(right[0]) ? str[0] : str[1];
                    System.out.println(larger);
                } else {
                    System.out.println("ERROR");
                }
            }
        }
        in.close();
    }
}
