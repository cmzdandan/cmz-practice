package com.cmz.collection;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/12
 * @description 将字符串按Z字型反转
 * <p>将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。</p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * </p>
 */

/**
 * java中，两个整数相除，结果会直接得到向下取整的整数，会丢失小数点后面的值。
 * 如果希望不要丢失，相除后保留小数，应该先将其中一个整数强制转换为double类型或者float类型。
 */
public class ConvertZString {
    public static void main(String[] args) {
        String before = "abcdefg";
        int numRows = 3;
        String after = convert(before, numRows);
        System.out.println(after);
    }

    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 0 ) {
            return null;
        }
        // 计算出二维数组的列数(即：宽度)
        int coloum = (int) Math.ceil(s.length() / (double)numRows);
        Character[][] charArray = new Character[numRows][coloum];
        int row = 0;
        int col = 0;
        for(int i = 0; i < s.length(); i++) {
            charArray[row][col] = s.charAt(i);
            row++;
            if(row == numRows - 1) {
                row -= 1;
                col += 1;
            }
            if(row == -1) {
                row += 1;
                col += 1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Character[] chars : charArray) {
            for(Character c : chars) {
                if(c != null) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
