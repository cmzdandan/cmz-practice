package com.cmz.factory.factorymethod;

import com.cmz.factory.ICourse;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/16 0016
 * @description
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory javaFactory = new JavaCourseFactory();
        ICourse javaCourse = javaFactory.create();
        javaCourse.record();

        ICourseFactory pythonFactory = new PythonCourseFactory();
        ICourse pythonCourse = pythonFactory.create();
        pythonCourse.record();
    }
}
