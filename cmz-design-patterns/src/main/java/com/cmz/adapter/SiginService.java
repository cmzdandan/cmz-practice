package com.cmz.adapter;

import com.cmz.template.Member;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/20 0020
 * @description 登录逻辑
 * 假设这个是模拟老系统的登录注册的业务逻辑
 */
public class SiginService {

    /**
     * 注册方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    /**
     * 登录的方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password) {
        return null;
    }
}
