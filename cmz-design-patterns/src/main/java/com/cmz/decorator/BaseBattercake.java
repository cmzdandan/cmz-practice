package com.cmz.decorator;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 基本的煎饼（或者叫基础套餐）
 * 煎饼5元一个
 */
public class BaseBattercake extends AbstractBattercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
