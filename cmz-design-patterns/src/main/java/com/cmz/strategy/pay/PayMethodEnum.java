package com.cmz.strategy.pay;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/18 0018
 * @description 支付方式枚举
 */
public enum PayMethodEnum {
    ALI_PAY(1, "支付宝"), WECHAT_PAY(2, "微信钱包"), CASH_PAY(3, "现金");
    private int value;
    private String paymentMethod;

    PayMethodEnum(int value, String paymentMethod) {
        this.value = value;
        this.paymentMethod = paymentMethod;
    }

    public int getValue() {
        return value;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
