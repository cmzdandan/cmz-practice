package com.cmz.collection;

import java.util.*;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/17
 * @description 根据索引合并值
 * <p>
 *  数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * </p>
 */
public class IndexMergeValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<>();
        while (in.hasNext()) {
            int num = in.nextInt();
            int count = 0;
            while(count < num) {
                String kvString = in.nextLine();
                String[] kv = kvString.split(" ");
                if(map.containsKey(kv[0])) {
                    map.put(Integer.valueOf(kv[0]), map.get(Integer.valueOf(kv[0])) + Integer.valueOf(kv[1]));
                } else {
                    map.put(Integer.valueOf(kv[0]), Integer.valueOf(kv[1]));
                }
                count++;
            }
        }
        in.close();
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        iterator.forEachRemaining(element -> System.out.println(element + map.get(element)));
    }
}
