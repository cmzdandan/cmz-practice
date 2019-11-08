package com.cmz.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 促销策略工厂
 */
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK, new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY, new GroupbuyStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    private PromotionStrategyFactory(){}

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }


}
