package com.cmz.prototype;

import java.io.Serializable;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/18 0018
 * @description
 */
public class Student implements Serializable {
    private String name;
    private int age;
    private String sex;
    private boolean atClassroom;

    public Student() {}

    public Student(String name, int age, String sex, boolean atClassroom) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.atClassroom = atClassroom;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isAtClassroom() {
        return atClassroom;
    }

    public void setAtClassroom(boolean atClassroom) {
        this.atClassroom = atClassroom;
    }
}
