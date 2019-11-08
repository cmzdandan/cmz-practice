package com.cmz.factory.simplefactory;

import com.cmz.factory.ICourse;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/15 0015 0:29
 * @description
 */
public class CourseFactory {

    public ICourse create(Class<? extends ICourse> clazz) {
        try{
            if(null != clazz) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
