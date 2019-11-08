package com.cmz.decorator;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 鸡蛋煎饼装饰器
 * 在煎饼装饰器的基础上加鸡蛋，加价格
 */
public class EggBattercakeDecorator extends BattercakeDecotator {

    public EggBattercakeDecorator(AbstractBattercake battercake) {
        super(battercake);
    }
    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + " +1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
