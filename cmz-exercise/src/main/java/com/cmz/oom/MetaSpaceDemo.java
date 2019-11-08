package com.cmz.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/20
 * @description java.lang.OutOfMemoryError:MetaSpace
 * <p>
 *  故障现象：
 * java.lang.OutOfMemoryError:MetaSpace
 * 异常分析：
 * 元空间不足，加载进来了太多的数据，就会报该异常。
 * Java 8及 之后的版本适用 MetaSpace 来代替永久代。
 * MetaSpace 是方法区在 HotSpot 中的实现，它与持久代最大的区别在于：MetaSpace并不在虚拟机内存中，而是使用本地内存。
 * 也即在 Java8 中，classe metadata(the virtual machines internal presentation of Java class) 被存储在叫做
 * MetaSpace的 Native Memory
 *
 * 永久代(Java8及以后被元空间MetaSpace取代了)存放了以下信息：
 * 虚拟机加载的类信息
 * 常量池
 * 静态变量
 * 即时编译后的代码
 *
 * 模拟元空间被撑爆
 * 我们设定JVM启动参数，调小元空间 -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * 然后不断生成类往元空间灌输，类占据的空间终究会超过MetaSpace指定的空间大小的
 * </p>
 */
public class MetaSpaceDemo {

    // 设置一个静态内部类，作为反射的父类
    static class OOMTest { }

    public static void main(String[] args) {
        int i = 0;
        try {
            while(true) {
                i++;
                Enhancer enhancer = new Enhancer();// 字节码技术
                enhancer.setSuperclass(OOMTest.class);// 设置父类
                enhancer.setUseCache(false);// 不使用缓存
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("########## 多次元空间被撑爆：" + i);
            e.printStackTrace();
        }
    }
}
