package com.cmz.strategy.promotion;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description
 */
public class PromotionActivityTest {
    public static void main(String[] args) {
//        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
//        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());
//        activity618.execute();
//        activity1111.execute();

       /* PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";
        if("COUPON".equals(promotionKey)){
            promotionActivity = new PromotionActivity(new CouponStrategy());
        }else if("CASHBACK".equals(promotionKey)){
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }else if("GROUPBUY".equals(promotionKey)) {
            promotionActivity = new PromotionActivity(new GroupbuyStrategy());
        }else{
            promotionActivity = new PromotionActivity(new EmptyStrategy());
        }
        promotionActivity.execute();*/

        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }
}
