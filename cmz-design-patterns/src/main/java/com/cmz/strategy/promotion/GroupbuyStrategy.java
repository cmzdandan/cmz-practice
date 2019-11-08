package com.cmz.strategy.promotion;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 拼团优惠
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满 20 人成团，全团享受团购价");
    }
}
