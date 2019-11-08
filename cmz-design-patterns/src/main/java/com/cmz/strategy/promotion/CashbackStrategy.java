package com.cmz.strategy.promotion;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 返现活动
 */
public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额转到支付宝账号");
    }
}
