package com.cmz.singleton;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/17 0017
 * @description 注册登记--枚举式单例
 *
 */
public class RegisterSingletonFromEnum {

    /**
     * 私有化构造器
     */
    private RegisterSingletonFromEnum() {}

    /**
     * 使用 enum 实例特性创建 RegisterSingletonFromEnum 类对象
     */
    private enum Singleton {
        INSTANCE;
        private RegisterSingletonFromEnum instance;
        // JVM保证该方法只被调用一次
        Singleton() {
            instance = new RegisterSingletonFromEnum();
        }
        public RegisterSingletonFromEnum getInstance() {
            return instance;
        }
    }

    /**
     * 提供公共静态的获取该类对象的方法
     */
    public static RegisterSingletonFromEnum getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
