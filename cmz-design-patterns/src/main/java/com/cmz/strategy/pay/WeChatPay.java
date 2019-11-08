package com.cmz.strategy.pay;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/18 0018
 * @description 微信支付
 * 这个就是具体的支付方式，继承  支付抽象策略，实现其抽象方法
 */
public class WeChatPay extends BasePayStrategy {
    @Override
    void pay(double payAmount, String paymentMethod) {
        System.out.println("正在使用微信支付...");
        System.out.println("使用" + paymentMethod + "支付：" + payAmount + "元");
    }
}
