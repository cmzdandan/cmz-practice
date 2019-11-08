package com.cmz.template;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/19 0019
 * @description
 */
public class NetworkCourseTest {

    public static void main(String[] args) {
        System.out.println("---Java 架构师课程---");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();

        System.out.println("---大数据课程---");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }

}
