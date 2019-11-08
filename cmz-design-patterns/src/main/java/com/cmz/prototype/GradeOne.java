package com.cmz.prototype;

import java.io.*;
import java.util.List;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/18 0018
 * @description 一年级(用来模拟一个复杂的对象)
 * 原型模式：深拷贝与浅拷贝
 * 浅拷贝：也就是值拷贝，如果原对象的值发生了改变则新对象的值跟着改变；
 * 深拷贝则是按流的方式进行拷贝，是值拷贝，而不是引用的拷贝，原对象与新对象各自互不影响。
 *
 * 最主要的就是重新拷贝方法
 */
public class GradeOne implements Cloneable, Serializable {
    private List<Student> students;
    private String classAddress;

    public GradeOne() {
    }

    public GradeOne(List<Student> students, String classAddress) {
        this.students = students;
        this.classAddress = classAddress;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getClassAddress() {
        return classAddress;
    }

    public void setClassAddress(String classAddress) {
        this.classAddress = classAddress;
    }

    /**
     * 原型模式最重要的就是克隆方法了
     */
    public GradeOne deepClone() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (GradeOne) ois.readObject();

    }
}
