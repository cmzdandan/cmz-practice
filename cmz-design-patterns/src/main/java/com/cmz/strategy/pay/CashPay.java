package com.cmz.strategy.pay;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/18 0018
 * @description
 */
public class CashPay extends BasePayStrategy {
    @Override
    void pay(double payAmount, String paymentMethod) {
        System.out.println("正在使用现金支付...");
        System.out.println("使用" + paymentMethod + "支付：" + payAmount + "元");
    }
}
