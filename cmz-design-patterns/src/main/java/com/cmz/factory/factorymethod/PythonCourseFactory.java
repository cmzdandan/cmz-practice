package com.cmz.factory.factorymethod;

import com.cmz.factory.ICourse;
import com.cmz.factory.PythonCourse;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/16 00160:44
 * @description
 */
public class PythonCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new PythonCourse();
    }
}
