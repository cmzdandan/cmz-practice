package com.cmz.strategy.promotion;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 优惠券策略
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券,课程的价格直接减优惠券面值抵扣");
    }
}
