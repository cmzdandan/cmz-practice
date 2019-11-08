package com.cmz.reference;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description 强引用示例
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object object1 = new Object();// 这样定义的，默认就是强引用
        Object object2 = object1;// object2引用赋值，实际上也是强引用
        object1 = null;// 断开object1的引用
        System.gc();
        // 经过GC后，仍然可以打印出object2，所以，object2还是强引用
        System.out.println(object2);
    }
}
