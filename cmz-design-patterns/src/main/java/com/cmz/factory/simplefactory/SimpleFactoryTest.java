package com.cmz.factory.simplefactory;

import com.cmz.factory.ICourse;
import com.cmz.factory.JavaCourse;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/15 0015 0:32
 * @description
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.record();
    }
}
