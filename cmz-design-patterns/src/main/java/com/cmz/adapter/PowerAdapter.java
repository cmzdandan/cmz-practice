package com.cmz.adapter;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/20 0020
 * @description 电源适配器(充电器)
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        // 接到220V的电压上
        int adapterInput = ac220.outputAC220V();
        //变压器...
        int adapterOutput = adapterInput / 44;
        System.out.println("使用 PowerAdapter 输入 AC:" + adapterInput + "V" + "输出DC:" + adapterOutput + "V");
        return adapterOutput;
    }
}
