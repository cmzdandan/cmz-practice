package com.cmz.oom;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/19
 * @description StackOverFlow示例
 * <p>
 *  栈空间溢出错误，递归方法调用，调用的层次过深就很容易引发该异常
 * </p>
 */
public class StackOverFlowDemo {
    public static void main(String[] args) {
        stackOverFlow();
    }

    // Exception in thread "main" java.lang.StackOverflowError
    private static void stackOverFlow() {
        stackOverFlow();
    }
}
