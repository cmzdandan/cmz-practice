package com.cmz.adapter;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/20 0020
 * @description
 */
public class AdapterTest {

    public static void main(String[] args) {
        // 通过构造器传入220V，也就是说，我们的充电器接上220V的电源
        DC5 dc5 = new PowerAdapter(new AC220());
        // 充电器输出5V电压
        dc5.outputDC5V();
    }

}
