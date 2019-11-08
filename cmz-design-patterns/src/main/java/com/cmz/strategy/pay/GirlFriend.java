package com.cmz.strategy.pay;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/18 0018
 * @description
 * 女朋友：支付主体，这里为支付策略的上下文
 */
public class GirlFriend {
    /**
     * 策略抽象类作为成员变量
     */
    private BasePayStrategy payStrategy;

    /**
     * 构造方法中传入具体的策略实现类对象
     * @param payStrategy
     */
    public GirlFriend(BasePayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 支付方法调用抽象方法（当前类被调用的时候会传入具体的策略对象的引用，最终调用的是具体策略的pay方法）
     * @param payAmount
     * @param paymentMethod
     */
    public void pay(double payAmount, String paymentMethod) {
        payStrategy.pay(payAmount, paymentMethod);
    }
}
