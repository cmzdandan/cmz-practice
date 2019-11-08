package com.cmz.observer.again;

import java.util.Observable;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/22 0022
 * @description 微信公众号(被观察者)
 * 一旦收到关注，就打印欢迎信息
 */
public class PublicAccount extends Observable {
    /**
     * 私有化构造器
     */
    private PublicAccount(){}

    /**
     * 声明私有的静态类对象
     */
    private static PublicAccount account = new PublicAccount();

    /**
     * 提供公共的静态方法获取类对象
     */
    public static PublicAccount getInstance() {
        return account;
    }

    /**
     * 出新闻了(此时会去通知所有的观察者)
     */
    public void publishNews(News news) {
        System.out.println("日期：" + news.getDate() + " 标题：" + news.getTitle());
        // 设置状态变化
        setChanged();
        // 正式通知所有的观察者，并且把新闻推送过去
        notifyObservers(news);
    }
}
