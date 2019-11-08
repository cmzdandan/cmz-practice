package com.cmz.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description WeakHashMap示例
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("=====================");
        myWeakHashMap();
    }

    // WeakHashMap
    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        // 下面用了 new，就能看出来弱引用的效果；如果直接赋值2，看不出效果
        Integer key = new Integer(2);
        // Integer key = 2;
        String value = "WeakHashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }

    // HashMap 基本操作
    private static void myHashMap() {
        String key = "key1";
        String value = "HashMap";
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        System.out.println(map);
        /*
         * 将上面声明的 String 类型的 key 置为 null，不会影响map中的key
         */
        key = null;
        System.gc();
        // 再次查看map的内容，不会受影响
        System.out.println(map);
    }
}
