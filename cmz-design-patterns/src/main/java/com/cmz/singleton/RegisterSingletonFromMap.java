package com.cmz.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/17 0017
 * @description 注册登记式 -- map容器单例
 *
 */
public class RegisterSingletonFromMap {

    /** 私有化类构造器 */
    private RegisterSingletonFromMap() {}

    /** 使用 ConcurrentHashMap 容器，装载 RegisterSingletonFromMap 类对象 */
    private static Map<String, RegisterSingletonFromMap> map = new ConcurrentHashMap<>();

    /**
     * 提供公共的静态的获取该类对象的方法
     */
    public static RegisterSingletonFromMap getInstance() {
        String className = RegisterSingletonFromMap.class.getName();
        synchronized (RegisterSingletonFromMap.class) {
            if(!map.containsKey(className)) {
                map.put(className, new RegisterSingletonFromMap());
            }
        }
        return map.get(className);
    }

}
