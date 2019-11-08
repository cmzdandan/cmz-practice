package com.cmz.decorator;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/21 0021
 * @description 装饰器模式测试类<p>
 * 跟静态代理最大区别就是职责不同
 * 静态代理不一定要满足 is-a 的关系
 * 静态代理会做功能增强，同一个职责变得不一样
 */
public class BattercakeTest {
    public static void main(String[] args) {
        AbstractBattercake battercake;
        // 路边摊买一个煎饼
        battercake = new BaseBattercake();
        // 煎饼有点小，想再加一个鸡蛋
        battercake = new EggBattercakeDecorator(battercake);
        // 再加根香肠
        battercake = new SausageBattercakeDecorator(battercake);
        // 结账
        System.out.println(battercake.getMsg() + ",总价：" + battercake.getPrice());
    }
}
