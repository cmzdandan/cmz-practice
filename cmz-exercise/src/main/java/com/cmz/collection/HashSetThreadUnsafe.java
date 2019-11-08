package com.cmz.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description HashSet线程不安全
 */
public class HashSetThreadUnsafe {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        // Set<String> set = new CopyOnWriteArraySet<>();
        for(int i = 0; i < 20; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }, "Thread-" + i).start();
        }
    }

}
