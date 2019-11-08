package com.cmz.observer.again;

import java.util.Date;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/22 0022
 * @description
 */
public class MyTest {
    public static void main(String[] args) {
        // 确定被观察者
        PublicAccount account = PublicAccount.getInstance();
        // 产生用户
        User userChen = new User();
        userChen.setUsername("cmz");
        User userZheng = new User();
        userZheng.setUsername("zdd");
        // 用户关注公众号
        account.addObserver(userChen);
        account.addObserver(userZheng);
        // 产生新闻
        News news = new News();
        news.setDate(new Date());
        news.setTitle("cmz will marry zdd");
        news.setContent("Oh my gold, you don't know that? CMZ will marry ZDD soon.");
        // 公众号发布新闻
        account.publishNews(news);
    }
}
