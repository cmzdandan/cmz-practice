package com.cmz.strategy.pay;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/18 0018
 * @description 支付策略（抽象类）
 */
public abstract class BasePayStrategy {

    /**
     * 支付
     *
     * @param payAmount     支付金额
     * @param paymentMethod 支付方式
     */
    abstract void pay(double payAmount, String paymentMethod);
}
