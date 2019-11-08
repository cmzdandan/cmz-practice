package com.cmz.factory.abstractfactory;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/16 0016
 * @description
 */
public interface ICourseFactory {
    INote createNote();
    IVideo createVideo();
}
