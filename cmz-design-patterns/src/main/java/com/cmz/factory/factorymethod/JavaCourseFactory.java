package com.cmz.factory.factorymethod;

import com.cmz.factory.ICourse;
import com.cmz.factory.JavaCourse;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/16 0016 0:41
 * @description
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
