package com.cmz.observer.again;

import java.util.Observable;
import java.util.Observer;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/22 0022
 * @description 用户(观察者)
 * 接受被观察者推送过来的消息
 */
public class User implements Observer {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void update(Observable o, Object arg) {
        // 被观察者(需要用到其信息就用，不需要用就不用)
        PublicAccount account = (PublicAccount) o;
        // 推送的消息
        News news = (News) arg;
        // 读取推送过来的消息
        System.out.println("------------------------------------------------------");
        System.out.println("嗨 " + username + " ，你好，你收到如下新闻：");
        System.out.println("于 " + news.getDate() + " 发生了 " + news.getTitle());
        System.out.println("事件详情：" + news.getContent());
    }
}
