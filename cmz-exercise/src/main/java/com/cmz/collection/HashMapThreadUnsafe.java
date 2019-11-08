package com.cmz.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description HashMap线程不安全
 */
public class HashMapThreadUnsafe {

    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        // Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();
        for(int i = 0; i < 15; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, "Thread-" + i).start();
        }
    }

}
