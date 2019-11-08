package com.cmz.template;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/19 0019
 * @description
 */
public class BigDataCourse extends NetworkCourse {

    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    void checkHomework() {
        System.out.println("检查大数据的课后作业");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
