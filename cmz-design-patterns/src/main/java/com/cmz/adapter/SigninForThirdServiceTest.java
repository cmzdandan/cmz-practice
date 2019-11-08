package com.cmz.adapter;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/20 0020
 * @description
 */
public class SigninForThirdServiceTest {
    public static void main(String[] args) {
        SigninForThirdService service = new SigninForThirdService();
        //不改变原来的代码，也要能够兼容新的需求
        //还可以再加一层策略模式
        service.loginForQQ("abcdefghijklmnopqrstuvwxyz");
    }
}
