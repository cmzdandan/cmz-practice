package com.cmz.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/14
 * @description ArrayList线程不安全
 */
public class ArrayListThreadUnsafe {

    public static void main(String[] args) {
        // 单线程情况下，运行没有问题
//        List<String> list = Arrays.asList("a", "b", "c");
//        list.forEach(System.out::println);

        // List<String> list = new ArrayList<>();
        // List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, "Thread-" + i).start();
        }
    }

}
