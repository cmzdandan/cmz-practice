package com.cmz.volatiled;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/10
 * @description volatile study
 * <p>验证 volatile 的可见性</p>
 * <p>如果共享变量没有被volatile修饰，则其值的修改对其他线程不可见；反之可见</p>
 * <p>验证方式：主线程死循环，直到感知到共享变量的值被修改才退出死循环</p>
 */
public class VolatileVisibilityDemo implements Runnable {

    // 只有这里加上  volatile 关键字，共享变量的改变才能让其他线程立刻感知
    private volatile boolean flag = false;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true;
        System.out.println(Thread.currentThread().getName() + "将共享变量flag的修改为：" + getFlag());
    }

    public static void main(String[] args) {
        VolatileVisibilityDemo vvd = new VolatileVisibilityDemo();
        new Thread(vvd).start();
        // 如果能告知到共享变量变化，则跳出死循环
        while(true) {
            if(vvd.getFlag()) {
                break;
            }
        }
    }

}