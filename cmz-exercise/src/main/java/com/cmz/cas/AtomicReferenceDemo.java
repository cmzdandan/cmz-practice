package com.cmz.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/13
 * @description 原子引用类型示例
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        // 构造两个对象
        User zhangsan = new User("zhangsan", 18);
        User lisi = new User("lisi", 20);
        // 用原子类型对User类型进行包装
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zhangsan);
        // 比较并交换
        // 第一次比较并交换可以成功，返回true
        System.out.println(atomicReference.compareAndSet(zhangsan, lisi) + "\t" + atomicReference.get().toString());
        // 第二次比较并交换，不会成功，返回false
        System.out.println(atomicReference.compareAndSet(zhangsan, lisi) + "\t" + atomicReference.get().toString());
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User=[name=" + this.name + "; age=" + this.age + "]";
    }
}
