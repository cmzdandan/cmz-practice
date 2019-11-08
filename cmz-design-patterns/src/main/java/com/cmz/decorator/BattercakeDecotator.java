package com.cmz.decorator;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 扩展套餐的抽象装饰者
 */
public abstract class BattercakeDecotator extends AbstractBattercake {

    //静态代理，委派(继承且持有原类)
    private AbstractBattercake battercake;

    public BattercakeDecotator(AbstractBattercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
